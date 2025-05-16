use lapin::{options::*, types::FieldTable, Connection, ConnectionProperties};
use tokio;

#[tokio::main]
async fn main() {
    // Connect to RabbitMQ
    let addr = "amqp://127.0.0.1:5672/%2f";
    let conn = Connection::connect(addr, ConnectionProperties::default())
        .await
        .expect("Failed to connect to RabbitMQ");

    println!("Connected to RabbitMQ!");

    // Create a channel
    let channel = conn.create_channel().await.expect("Failed to create channel");

    // Declare a queue
    let queue = channel
        .queue_declare(
            "event_queue",
            QueueDeclareOptions::default(),
            FieldTable::default(),
        )
        .await
        .expect("Failed to declare queue");

    println!("Declared queue: {:?}", queue.name());

    // Start consuming messages
    let mut consumer = channel
        .basic_consume(
            "event_queue",
            "subscriber",
            BasicConsumeOptions::default(),
            FieldTable::default(),
        )
        .await
        .expect("Failed to start consuming");

    println!("Waiting for messages...");

    while let Some(delivery) = consumer.next().await {
        if let Ok((channel, delivery)) = delivery {
            let message = String::from_utf8_lossy(&delivery.data);
            println!("Received message: {}", message);

            // Acknowledge the message
            channel
                .basic_ack(delivery.delivery_tag, BasicAckOptions::default())
                .await
                .expect("Failed to acknowledge message");
        }
    }
}