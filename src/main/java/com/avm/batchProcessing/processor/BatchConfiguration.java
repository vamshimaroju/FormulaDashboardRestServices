package com.avm.batchProcessing.processor;

import javax.sql.DataSource;

import com.avm.batchProcessing.vo.RacesBatch;
import com.avm.batchProcessing.vo.SeasonsBatch;
import com.avm.batchProcessing.vo.StatusBatch;
import com.avm.entities.Races;
import com.avm.entities.Seasons;
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

    private final String[] STATUS_FIELD_NAMES = new String[] { "statusId", "status" };
    private final String[] RACES_FIELD_NAMES = new String[] { "raceId", "year", "round", "circuitId", "name", "date",
            "time", "url" };
    private final String[] SEASONS_FIELD_NAMES = new String[]{"year","url"};

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    /*
     *
     *
     * Batch process to insert Status data into the tables
     *
     */
    @Bean
    public FlatFileItemReader<StatusBatch> statusReader() {
        return new FlatFileItemReaderBuilder<StatusBatch>().name("statusReader")
                .resource(new ClassPathResource("/csv/status.csv")).delimited().names(STATUS_FIELD_NAMES)
                .fieldSetMapper(new BeanWrapperFieldSetMapper<StatusBatch>() {
                    {
                        setTargetType(StatusBatch.class);
                    }
                }).build();
    }

    @Bean
    public StatusProcessor statusProcess() {
        return new StatusProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<Status> statusWriter(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Status>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO status (status_id, status) VALUES (:statusId, :status)").dataSource(dataSource)
                .build();
    }

    /*
     * @Bean public Job importStatusJob(JobCompletionNotificationListener listener,
     * Step statusStep) { return jobBuilderFactory .get("importStatusJob")
     * .incrementer(new RunIdIncrementer()) .listener(listener)
     * .flow(statusStep).end().build(); }
     */
    @Bean
    public Step statusStep(JdbcBatchItemWriter<Status> writer) {
        return stepBuilderFactory.get("statusStep").<StatusBatch, Status>chunk(10).reader(statusReader())
                .processor(statusProcess()).writer(writer).build();
    }

    /*
     *
     *
     * Batch process to insert Races data into the tables
     *
     */

    @Bean
    public FlatFileItemReader<RacesBatch> racesReader() {
        return new FlatFileItemReaderBuilder<RacesBatch>().name("racesReader")
                .resource(new ClassPathResource("/csv/races.csv")).delimited().names(RACES_FIELD_NAMES)
                .fieldSetMapper(new BeanWrapperFieldSetMapper<RacesBatch>() {
                    {
                        setTargetType(RacesBatch.class);
                    }
                }).build();
    }

    @Bean
    public RaceProcessor raceProcess() {
        return new RaceProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<Races> racesWriter(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Races>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO races (race_id,year,round,circuit_id,name,date,time,url) VALUES (:raceId,:year,:round,:circuitId,:name,:date,:time,:url)")
                .dataSource(dataSource).build();
    }

/*     @Bean
    public Job importRacesJob(JobCompletionNotificationListener listener, Step racesStep) {
        return jobBuilderFactory.get("importRacesJob").incrementer(new RunIdIncrementer()).listener(listener)
                .flow(racesStep).end().build();
    }
 */
    @Bean
    public Step racesStep(JdbcBatchItemWriter<Races> writer) {
        return stepBuilderFactory.get("racesStep").<RacesBatch, Races>chunk(10).reader(racesReader())
                .processor(raceProcess()).writer(writer).build();
    }

    /*
     *
     *
     * Batch process to insert Seasons data into the tables
     *
     */

    @Bean
    public FlatFileItemReader<SeasonsBatch> seasonsReader() {
        return new FlatFileItemReaderBuilder<SeasonsBatch>().name("seasonsReader")
                .resource(new ClassPathResource("/csv/seasons.csv")).delimited().names(SEASONS_FIELD_NAMES)
                .fieldSetMapper(new BeanWrapperFieldSetMapper<SeasonsBatch>() {
                    {
                        setTargetType(SeasonsBatch.class);
                    }
                }).build();
    }

    @Bean
    public SeasonsProcessor seasonsProcess() {
        return new SeasonsProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<Seasons> seasonsWriter(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Seasons>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO seasons (year,url ) values (:year,:url)")
                .dataSource(dataSource).build();
    }

/*     @Bean
    public Job importSeasonsJob(JobCompletionNotificationListener listener, Step seasonsStep) {
        return jobBuilderFactory.get("importSeasonsJob").incrementer(new RunIdIncrementer()).listener(listener)
                .flow(seasonsStep).end().build();
    }
 */
    @Bean
    public Step seasonsStep(JdbcBatchItemWriter<Seasons> writer) {
        return stepBuilderFactory.get("seasonsStep").<SeasonsBatch, Seasons>chunk(10).reader(seasonsReader())
                .processor(seasonsProcess()).writer(writer).build();
    }
}
