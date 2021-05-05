package com.avm.batchProcessing.processor;

import javax.sql.DataSource;

import com.avm.batchProcessing.vo.StatusBatch;
import com.avm.entities.Status;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    private final String[] STATUS_FIELD_NAMES = new String[] { "statusId","status" };

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    public FlatFileItemReader<StatusBatch> reader() {
        return new FlatFileItemReaderBuilder<StatusBatch>().name("statusReader")
                .resource(new ClassPathResource("/csv/status.csv")).delimited().names(STATUS_FIELD_NAMES)
                .fieldSetMapper(new BeanWrapperFieldSetMapper<StatusBatch>() {
                    {
                        setTargetType(StatusBatch.class);
                    }
                }).build();
    }

    @Bean
    public StatusProcessor processor() {
        return new StatusProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<Status> writer(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Status>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO status (status_id, status) VALUES (:statusId, :status)").dataSource(dataSource)
                .build();
    }

    @Bean
    public Job importStatusJob(JobCompletionNotificationListener listener, Step statusStep) {
        return jobBuilderFactory
                .get("importStatusJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(statusStep).end().build();
    }

    @Bean
    public Step statusStep(JdbcBatchItemWriter<Status> writer) {
        return stepBuilderFactory
                .get("statusStep")
                .<StatusBatch, Status>chunk(10)
                .reader(reader())
                .processor(processor()).writer(writer).build();
    }
}
