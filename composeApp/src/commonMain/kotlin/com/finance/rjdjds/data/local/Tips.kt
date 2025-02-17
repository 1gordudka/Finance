package com.finance.rjdjds.data.local

import androidx.compose.ui.graphics.Color

data class Tip(
    val name: String,
    val description: String,
)

val tips = listOf(
    Tip(
        name = "Build an Emergency Fund",
        description = "An emergency fund is the cornerstone of financial security. Aim to save 3–6 months' worth of living expenses in a liquid, high-yield savings account. This fund acts as a financial buffer against unexpected events like job loss, medical emergencies, or urgent home repairs. Start small with monthly contributions and automate transfers to make saving effortless. Treat this fund as non-negotiable – only for true emergencies, not discretionary spending."
    ),
    Tip(
        name = "Master Budgeting Techniques",
        description = "Implement the 50/30/20 rule: allocate 50% of income to needs (housing, utilities, groceries), 30% to wants (entertainment, dining), and 20% to savings/debt repayment. Use budgeting apps to track expenses in real-time and identify spending leaks. Conduct monthly budget reviews to adjust for life changes. Consider zero-based budgeting where every dollar has a purpose. Remember, budgeting isn't restriction – it's about conscious spending alignment with priorities."
    ),
    Tip(
        name = "Aggressively Pay High-Interest Debt",
        description = "Prioritize eliminating credit card debt and loans with APRs above 7% using either the avalanche method (target highest interest rates first) or snowball method (pay smallest balances first for psychological wins). Consider balance transfers to 0% APR cards or debt consolidation loans. Automate payments above minimum requirements. Avoid new debt while paying existing balances. Calculate how much interest you're saving – this becomes motivation capital."
    ),
    Tip(
        name = "Invest Early and Consistently",
        description = "Start investing in low-cost index funds/ETFs through tax-advantaged accounts (401(k), Roth IRA). Implement dollar-cost averaging – invest fixed amounts regularly regardless of market conditions. Aim to invest 15-20% of income. Take full advantage of employer 401(k) matches. Diversify across asset classes (stocks, bonds, REITs) and geographies. Reinvest dividends and let compound growth work over decades. Increase contributions with every raise or bonus."
    ),
    Tip(
        name = "Optimize Retirement Planning",
        description = "Maximize tax-advantaged retirement accounts annually ($22,500 for 401(k), $6,500 for IRA in 2023). Consider Roth options if expecting higher future taxes. Use catch-up contributions if over 50. Project retirement needs using 4% withdrawal rule. Develop multiple income streams – Social Security, pensions, rental income, and investment portfolios. Periodically rebalance allocations to maintain risk tolerance. Consult a fiduciary advisor for complex planning needs."
    ),
    Tip(
        name = "Implement Strategic Insurance Coverage",
        description = "Secure term life insurance (10-15x income) if others depend on your earnings. Maintain adequate health insurance with HSA contributions if eligible. Protect assets with umbrella insurance ($1M+ coverage). Ensure proper disability insurance – both short-term and long-term. Review policies annually – avoid over-insuring depreciating assets or under-insuring critical risks. Compare providers every 3-5 years for better rates. Understand deductibles vs. premiums trade-offs."
    ),
    Tip(
        name = "Build and Monitor Credit Health",
        description = "Maintain credit utilization below 30% across all cards. Never miss payments – set autopay for minimums. Keep old accounts open to lengthen credit history. Space credit applications by 6+ months. Dispute credit report errors annually via AnnualCreditReport.com. Consider becoming authorized user on established accounts to boost history. Use credit monitoring services. Aim for 750+ FICO score to qualify for best loan rates and premium credit cards."
    ),
    Tip(
        name = "Continuous Financial Education",
        description = "Dedicate 1-2 hours weekly to financial literacy. Read classics like 'The Intelligent Investor' and modern works like 'Psychology of Money'. Follow reputable financial blogs/podcasts (ChooseFI, BiggerPockets). Take courses on tax strategies, real estate investing, or stock analysis. Attend local investor meetups. Learn to interpret financial statements and economic indicators. Stay updated on tax law changes and new investment vehicles. Knowledge compounds like money."
    ),
    Tip(
        name = "Implement Tax Optimization Strategies",
        description = "Maximize pre-tax contributions to retirement accounts and HSAs. Harvest tax losses in investment portfolios. Utilize 529 plans for education savings. Structure charitable giving through donor-advised funds. Time capital gains realization to lower tax brackets. Consider opportunity zones for capital gains deferral. If self-employed, explore SEP IRA/Solo 401(k). Work with CPA for entity structuring (LLC, S-Corp). Keep meticulous records of deductible expenses."
    ),
    Tip(
        name = "Develop Estate Planning Essentials",
        description = "Create will and living trust to avoid probate. Designate beneficiaries for all financial accounts. Establish durable power of attorney and healthcare directives. Consider irrevocable trusts for asset protection and tax efficiency. Document digital assets and passwords in secure vault. Review estate plans every 3-5 years or after major life events. For complex estates, use family limited partnerships. Communicate plans with heirs to prevent disputes. Store documents securely with attorney copies."
    )
)