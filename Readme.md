This is a sample code to show Orchestrator Saga pattern

Key Functionality or requirement on which this is build

- An Order request is generated from the customer
- we need to hold the product in the inventory 
- then we need to process the payment 
- if the payment processing fails we need to clear the hold in the inventory
- also once the payment is complete we need to generate a notification to the customer

all this steps needs to be in synchronized manner and auditable

Async requirement
- notification 
- auditing of each step or process


PLEASE NOTE : 
THIS IS FOR LEARNING PURPOSE AND IS INFLUENCED FROM ORCHESTRATOR SAGA PATTERN