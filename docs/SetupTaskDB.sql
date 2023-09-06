DROP TABLE IF EXISTS task;
CREATE TABLE task(id SERIAL PRIMARY KEY, name VARCHAR(50), description VARCHAR(50), priority VARCHAR(50));

INSERT INTO task (name, description, priority) VALUES ('cleaning', 'Clean the house', 'Low');
INSERT INTO task (name, description, priority) VALUES ('gardening', 'Mow the lawn', 'Medium');
INSERT INTO task (name, description, priority) VALUES ('shopping', 'Buy the groceries', 'High');
INSERT INTO task (name, description, priority) VALUES ('painting', 'Paint the fence', 'Medium');
INSERT INTO task (name, description, priority) VALUES ('exercising', 'Walk the dog', 'Medium');
INSERT INTO task (name, description, priority) VALUES ('meditating', 'Contemplate the infinite', 'High');