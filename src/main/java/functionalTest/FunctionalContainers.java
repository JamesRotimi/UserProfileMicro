package functionalTest;

import org.testcontainers.containers.PostgreSQLContainer;

public class FunctionalContainers extends PostgreSQLContainer<FunctionalContainers> {

        private static final String IMAGE_VERSION = "postgres:alpine";

        private static FunctionalContainers postgresContainer;

        private FunctionalContainers() {
            super(IMAGE_VERSION);
        }

        public static FunctionalContainers getInstance() {
            if (postgresContainer == null) {
                postgresContainer = new FunctionalContainers();
            }
            return postgresContainer;
        }

        @Override
        public void start() {
            super.start();
            System.setProperty("DB_URL", postgresContainer.getJdbcUrl());
            System.setProperty("DB_USERNAME", postgresContainer.getUsername());
            System.setProperty("DB_PASSWORD", postgresContainer.getPassword());
        }
}
