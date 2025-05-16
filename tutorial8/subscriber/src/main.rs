use borsh::{BorshDeserialize, BorshSerialize};
use crosstown_bus::{CrosstownBus, MessageHandler, HandleError};
use std::{thread, time};

/// Struct representing the `UserCreatedEventMessage`
/// This message contains the user ID and user name.
#[derive(Debug, Clone, BorshDeserialize, BorshSerialize)]
pub struct UserCreatedEventMessage {
    pub user_id: String,
    pub user_name: String,
}

/// Handler for processing `UserCreatedEventMessage` messages.
pub struct UserCreatedHandler;

impl MessageHandler<UserCreatedEventMessage> for UserCreatedHandler {
    fn handle(&self, message: Box<UserCreatedEventMessage>) -> Result<(), HandleError> {
        // Simulate a 1-second processing delay
        let processing_delay = time::Duration::from_millis(1000);
        thread::sleep(processing_delay);

        // Log the received message
        println!(
            "In Syarna Savitri's Computer [2206083565]. Message received: {:?}",
            message
        );

        Ok(())
    }

    fn get_handler_action(&self) -> String {
        // Return a string that identifies the action of this handler
        // For example, you can return the name of the queue or the type of message it handles
        "user_created_handler".to_owned()
    }
}

fn main() {
    // RabbitMQ connection string
    let rabbitmq_url = "amqp://guest:guest@localhost:5672".to_owned();

    // Create a new queue listener for the CrosstownBus
    let listener = CrosstownBus::new_queue_listener(rabbitmq_url)
        .expect("Failed to create queue listener");

    // Start listening to the "user_created" queue with the `UserCreatedHandler`
    listener
        .listen(
            "user_created".to_owned(),
            UserCreatedHandler {},
            crosstown_bus::QueueProperties {
                auto_delete: false, // Queue will not be deleted automatically
                durable: false,     // Queue is not durable (not persisted to disk)
                use_dead_letter: true, // Enable dead-letter queue for failed messages
            },
        )
        .expect("Failed to start listening to the queue");

    // Keep the program running to continuously listen for messages
    loop {
        thread::sleep(time::Duration::from_secs(1)); // Prevent busy looping
    }
}