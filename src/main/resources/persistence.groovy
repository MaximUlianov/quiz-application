import org.apache.tomcat.dbcp.dbcp2.BasicDataSource
import org.springframework.core.io.ClassPathResource
import org.springframework.orm.hibernate5.HibernateTransactionManager
import org.springframework.orm.hibernate5.LocalSessionFactoryBean

def propertiesMap = new Properties();
propertiesMap.load(new ClassPathResource("persistence.properties").inputStream)

beans {

    dataSource(BasicDataSource) { bean ->
        driverClassName = propertiesMap."db.jdbc.driver.name"
        url = propertiesMap."db.connection.url"
        username = propertiesMap."db.user.login"
        password = propertiesMap."db.user.password"
    }

    sessionFactory(LocalSessionFactoryBean) {
        dataSource = ref('dataSource')
        packagesToScan = 'com.bsuir.quiz.model'
        hibernateProperties = ["hibernate.show_sql"    : "true",
                               "hibernate.dialect"     : "org.hibernate.dialect.PostgreSQL10Dialect",
                               "hibernate.hbm2ddl.auto": "create"] as Properties
    }

    hibernateTransactionManager(HibernateTransactionManager, ref('sessionFactory'))
}
