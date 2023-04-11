package org.example.config;

import org.example.controllers.*;
import org.example.models.Books;
import org.example.models.Categories;
import org.example.models.Loan;
import org.example.models.Users;
import org.example.models.dto.MonthlyReport;
import org.example.repository.*;
import org.example.services.*;
import org.example.utils.IRandomStringGenerator;
import org.example.utils.UUIDGenerator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:application.properties")
public class BeanConfigruation {
    @Value("${driver}")
    private String dbDriver;
    @Value("${url}")
    private String url;
    @Value("${dbuser}")
    private String dbUser;
    @Value("${dbpassword}")
    private String dbPassword;

    @Bean
    public ILibraryService<Users> getUserService(){
        return new UsersService(getUserRepository());
    }
    @Bean
    public ILibraryRepository<Users> getUserRepository(){
        return new UserRepository(dataSource(), getRandomUUID());
    }

    @Bean
    public UsersController getUserController(){
        return new UsersController(getUserService());
    }

    @Bean
    public ILibraryService<Categories> getCategoriesService(){
        return new CategoriesService(getCategoriesRepository());
    }
    @Bean
    public ILibraryRepository<Categories> getCategoriesRepository(){
        return new CategoriesRepository(dataSource(), getRandomUUID());
    }
    @Bean
    public CategoriesController getCategoriesController(){
        return new CategoriesController(getCategoriesService());
    }
    @Bean
    public ILibraryService<Books> getBooksService(){
        return new BookService(getBooksRepository());
    }
    @Bean
    public ILibraryRepository<Books> getBooksRepository(){
        return new BookRepository(dataSource(), getRandomUUID());
    }
    @Bean
    public BooksController getBooksController(){
        return new BooksController(getBooksService());
    }
    @Bean
    public ILibraryService<Loan> getLoanService(){
        return new LoanService(getLoanRepository());
    }
    @Bean
    public ILibraryRepository<Loan> getLoanRepository(){
        return new LoanRepository(dataSource(), getRandomUUID());
    }
    @Bean
    public LoanController getLoanController(){
        return new LoanController(getLoanService());
    }

    @Bean
    public ReportController getReportController(){
        return new ReportController(getReportService());
    }
    @Bean
    public ReportService getReportService(){
        return new ReportService(getReportRepository());
    }
    @Bean
    public ReportRepository getReportRepository() {
        return new ReportRepository(dataSource());
    }

    @Bean
    public AppController getAppController(){
        return new AppController(getUserController(), getCategoriesController(), getBooksController(), getLoanController(), getReportController());
    }

    @Bean
    @Qualifier("randomUUID")
    public IRandomStringGenerator getRandomUUID(){
        return new UUIDGenerator();
    }
    @Bean
    DataSource dataSource(){
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setUrl(url);
        driverManagerDataSource.setUsername(dbUser);
        driverManagerDataSource.setPassword(dbPassword);
        driverManagerDataSource.setDriverClassName(dbDriver);

        return driverManagerDataSource;
    }

}
