package com.example.client.config;

import com.example.client.builders.UserItemReader;
import com.example.client.builders.UserItemWriter;
import com.example.client.data.UserData;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BatchConfig {


    @Autowired
    private RestTemplate restTemplate;

    private PlatformTransactionManager transactionManager;


    public BatchConfig(PlatformTransactionManager transactionManager, RestTemplate restTemplate) {
        this.transactionManager = transactionManager;
    }

    @Bean
   public Job job(JobRepository jobRepository, Step step){
       return new JobBuilder("job", jobRepository)
               .start(step)
               .incrementer(new RunIdIncrementer())
               .build();
   }

    @Bean
    public Step step(UserItemReader reader, UserItemWriter writer, JobRepository jobRepository){
       return new StepBuilder("step", jobRepository)
               .<UserData,UserData>chunk(200,transactionManager)
               .reader(reader)
               .writer(writer)
               .build();
    }

    @Bean
    public ItemReader<UserData> itemReader(RestTemplate restTemplate) {
        return new UserItemReader(restTemplate);
    }
}
