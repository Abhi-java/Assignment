package com.batch.config;
import javax.sql.DataSource;
import com.batch.entities.User;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@EnableBatchProcessing

public class BatchConfig {

	@Autowired
	private DataSource dataSource;
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	@Bean
	public FlatFileItemReader<User> reader(){
		
		 FlatFileItemReader<User> reader= new  FlatFileItemReader<>();
		 reader.setResource(new ClassPathResource("sampleDb.csv"));
		 reader.setLineMapper(getLineMapper());
		 reader.setLinesToSkip(1);
		 
		return reader;
	}
	
	public LineMapper<User> getLineMapper() {
		
		DefaultLineMapper<User> lineMapper = new DefaultLineMapper<>();
		
		DelimitedLineTokenizer lineTokenizer=new DelimitedLineTokenizer();
		lineTokenizer.setNames(new String [] {"Code","Name","Batch","Stock","Deal","Free","Mrp","Rate","Exp","Company","Supplier","SupplierID"});
		lineTokenizer.setIncludedFields(new int [] {0,1,2,3,4,5,6,7,8,9,10,11});
	
		
		BeanWrapperFieldSetMapper<User> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		
		fieldSetMapper.setTargetType(User.class);
		lineMapper.setLineTokenizer(lineTokenizer);
		lineMapper.setFieldSetMapper(fieldSetMapper);
		return lineMapper;
	}
    @Bean
    UserItemProcessor processor() {
        return new UserItemProcessor();
    }

    @Bean
    JdbcBatchItemWriter<User> writer() {
        JdbcBatchItemWriter<User> writer = new JdbcBatchItemWriter<User>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<User>());
        writer.setSql("insert into user(Code,Name,Batch,Stock,Deal,Free,Mrp,Rate,Exp,Company,Supplier,SupplierID) values (:Code,:Name,:Batch,:Stock,:Deal,:Free,:Mrp,:Rate,:Exp,:Company,:Supplier,:SupplierID)");
        writer.setDataSource(this.dataSource);
        return writer;
    }

    @Bean
    Job importUserJob() {
        return this.jobBuilderFactory.get("USER-IMPORT-JOB")
                .incrementer(new RunIdIncrementer())
                .flow(step1())
                .end()
                .build();
    }

    @Bean
    Step step1() {

        return this.stepBuilderFactory.get("step1")
                .<User, User>chunk(100)
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .build();

    }
	
}