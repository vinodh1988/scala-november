case class Transaction(id: String, amount: Double, totalAmount: Double)

object Transaction {
  // apply method with a code block parameter for fee calculation
  def apply(id: String, amount: Double)(feeCalculation: Double => Double): Transaction = {
    // Calculate the fee using the provided fee calculation function
    val fee = feeCalculation(amount)
    val totalAmount = amount + fee
    println(s"Creating transaction with ID: '$id', amount: $$${amount}, fee: $$${fee}, total amount: $$${totalAmount}")
    new Transaction(id, amount, totalAmount) // Return a new instance of Transaction
  }
}

@main def transact = {
// Using apply with a code block for calculating transaction fee
val transaction = Transaction("TX12345", 100.0) { amount =>
  if (amount > 50) amount * 0.05 // 5% fee for amounts above $50
  else 2.0                        // Flat $2 fee otherwise
}

println(s"Transaction Details: ID = ${transaction.id}, Amount = ${transaction.amount}, Total Amount = ${transaction.totalAmount}")
}