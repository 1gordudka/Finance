package com.finance.rjdjds.data.local

data class Question(
    val name: String,
    val answers: List<String>,
    val correct: Int,
)

val questions = listOf(
    Question(
        name = "What's the recommended emergency fund size?",
        answers = listOf(
            "1-2 months of expenses",
            "3-6 months of expenses",
            "9-12 months of expenses",
            "Only credit card limits"
        ),
        correct = 1
    ),
    Question(
        name = "Which percentage allocation describes the 50/30/20 rule?",
        answers = listOf(
            "50% savings, 30% needs, 20% wants",
            "50% wants, 30% needs, 20% debt",
            "50% needs, 30% wants, 20% savings/debt",
            "Equal thirds for all categories"
        ),
        correct = 2
    ),
    Question(
        name = "What's the FIRST debt to pay off aggressively?",
        answers = listOf(
            "Mortgage",
            "Student loans",
            "Car payment",
            "Credit card balances"
        ),
        correct = 3
    ),
    Question(
        name = "What's the main advantage of compound interest?",
        answers = listOf(
            "Immediate tax benefits",
            "Interest on principal only",
            "Growth on principal + accumulated interest",
            "Guaranteed returns"
        ),
        correct = 2
    ),
    Question(
        name = "What's the 2023 Roth IRA contribution limit?",
        answers = listOf(
            "\$3,500",
            "\$6,500",
            "\$10,000",
            "\$20,500"
        ),
        correct = 1
    ),
    Question(
        name = "What's the recommended term life insurance coverage?",
        answers = listOf(
            "1-3x annual income",
            "5-7x annual income",
            "10-15x annual income",
            "Equal to mortgage balance"
        ),
        correct = 2
    ),
    Question(
        name = "What credit utilization ratio maintains good credit?",
        answers = listOf(
            "Below 30%",
            "Below 50%",
            "Above 70%",
            "Unlimited usage"
        ),
        correct = 0
    ),
    Question(
        name = "What's a key benefit of Health Savings Accounts (HSAs)?",
        answers = listOf(
            "Tax-deductible contributions",
            "Tax-free withdrawals for medical expenses",
            "No contribution limits",
            "Both A and B"
        ),
        correct = 3
    ),
    Question(
        name = "What does the 4% retirement rule determine?",
        answers = listOf(
            "Ideal savings rate",
            "Safe annual withdrawal rate",
            "Stock allocation percentage",
            "Emergency fund growth"
        ),
        correct = 1
    ),
    Question(
        name = "What's tax-loss harvesting primarily used for?",
        answers = listOf(
            "Avoiding capital gains taxes",
            "Increasing dividend income",
            "Reducing taxable income",
            "Qualifying for Roth IRA"
        ),
        correct = 2
    ),
    Question(
        name = "What FICO score qualifies for the best loan rates?",
        answers = listOf(
            "650+",
            "700+",
            "750+",
            "800+"
        ),
        correct = 2
    ),
    Question(
        name = "What do 529 plans primarily fund?",
        answers = listOf(
            "Retirement",
            "Medical expenses",
            "Education costs",
            "Business startups"
        ),
        correct = 2
    ),
    Question(
        name = "The 'avalanche method' prioritizes:",
        answers = listOf(
            "Smallest debts first",
            "Highest interest rates first",
            "Credit score impact",
            "Monthly cash flow"
        ),
        correct = 1
    ),
    Question(
        name = "Umbrella insurance primarily covers:",
        answers = listOf(
            "Natural disasters",
            "Liability beyond standard policies",
            "Identity theft",
            "Investment losses"
        ),
        correct = 1
    ),
    Question(
        name = "What's a key advantage of index funds?",
        answers = listOf(
            "Active management",
            "High fees for better returns",
            "Low expense ratios",
            "Guaranteed outperformance"
        ),
        correct = 2
    )
)