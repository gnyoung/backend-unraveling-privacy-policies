# Privacy Grader (Backend)

Privacy Grader is a Chrome extension that reads, scores and summarizes privacy policies for users.

## Dependencies 
- Spring Boot Starter Data JPA
- Spring Boot Starter Web
- PostgreSQL Driver
- Google Gson Library
- Spring Boot Starter Test 

## Installation (IntelliJ IDEA)
1. Clone the repository. 
2. Open the project in IntelliJ by selecting "Open" from the home screen or with "File" > "Open". 
3. Create a new PostgreSQL database. 
4. Navigate to **'src/main/resources'** and create a new file named **'application.properties'**.
5. Add the following PostgreSQL credentials to **'application.properties'**:
   - `spring.datasource.username=your-database-username`
   - `spring.datasource.password=your-database-password`
   - `spring.datasource.url=jdbc:postgresql://your-database-url`
6. Add the following OpenAI configurations to **'application.properties'**:
    - `openai.apiKey=your-openai-api-key`
    - `openai.model=your-gpt-model`
    - `openai.api.url=your-gpt-url`
7. Finally, add the following Hibernate configurations to **'application.properties'**:
   - `spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect`
   - `spring.jpa.hibernate.ddl-auto=update`
8. Complete the installation by running the project from **'BackendUnravelingPrivacyPoliciesApplication.java'**.