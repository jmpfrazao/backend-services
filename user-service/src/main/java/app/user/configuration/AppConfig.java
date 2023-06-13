// package app.user.configuration;

// import app.user.listeners.ReleaseCascadeConvertMongoEventListener;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.data.mongodb.core.MongoTemplate;

// import com.mongodb.client.MongoClient;

// @Configuration
// public class AppConfig {
//     @Bean
//     MongoClient mongoClient() {
//         return new MongoClient;
//     }

//     @Bean
//     MongoTemplate mongoTemplate() {
//         return new MongoTemplate(mongoClient(), "trackzilla");
//     }

//     @Bean
//     ReleaseCascadeConvertMongoEventListener releaseCascadingMongoEventListener() {
//         return new ReleaseCascadeConvertMongoEventListener();
//     }
// }