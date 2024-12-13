package blackjack.card

import blackjack.card.Cards.Companion.createCardPack
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CardsTest : StringSpec({
    "카드를 받을 수 있다." {
        // Arrange:
        val cards = Cards()
        val card = Card(CardNumber.ACE, CardSuit.SPADES)

        // Act:
        cards.add(card)

        // Assert:
        cards.cards.size shouldBe 1
    }

    "카드를 여러장 뽑을 수 있다." {
        // Arrange:
        val cards = Cards()
        val card1 = Card(CardNumber.ACE, CardSuit.SPADES)
        val card2 = Card(CardNumber.TWO, CardSuit.SPADES)

        // Act:
        cards.addAll(listOf(card1, card2))

        // Assert:
        cards.cards.size shouldBe 2
    }

    "기본 카드팩을 만들 수 있다." {
        // Arrange & Act:
        val cards = createCardPack()

        // Assert:
        cards.size shouldBe 52
    }

    "보유한 카드팩의 합이 21이 넘으면 버스터(탈락)가 된다." {
        // Arrange:
        val cards = Cards()
        val card1 = Card(CardNumber.TEN, CardSuit.SPADES)
        val card2 = Card(CardNumber.TEN, CardSuit.HEARTS)
        val card3 = Card(CardNumber.TWO, CardSuit.SPADES)

        // Act:
        cards.addAll(listOf(card1, card2, card3))

        // Assert:
        cards.isBust() shouldBe true
    }

    "보유한 카드팩의 합이 21이 넘지 않으면 유효하다." {
        // Arrange:
        val cards = Cards()
        val card1 = Card(CardNumber.TEN, CardSuit.SPADES)
        val card2 = Card(CardNumber.TEN, CardSuit.HEARTS)

        // Act:
        cards.addAll(listOf(card1, card2))

        // Assert:
        cards.isBust() shouldBe false
    }

    "보유한 카드팩의 합이 21이 초과되지 않으면 유효하다. (Ace는 1로 계산될 수 있다.)" {
        // Arrange:
        val cards = Cards()
        val card1 = Card(CardNumber.TEN, CardSuit.SPADES)
        val card2 = Card(CardNumber.TEN, CardSuit.SPADES)
        val card3 = Card(CardNumber.ACE, CardSuit.SPADES)

        // Act:
        cards.addAll(listOf(card1, card2, card3))

        // Assert:
        cards.isBust() shouldBe false
    }

    "보유한 카드팩의 합이 21이 초과되면 버스터(탈락)가 된다. (단, Ace는 1로 계산될 수 있다.)" {
        // Arrange:
        val cards = Cards()
        val card1 = Card(CardNumber.TEN, CardSuit.SPADES)
        val card2 = Card(CardNumber.TEN, CardSuit.HEARTS)
        val card3 = Card(CardNumber.ACE, CardSuit.SPADES)
        val card4 = Card(CardNumber.ACE, CardSuit.HEARTS)

        // Act:
        cards.addAll(listOf(card1, card2, card3, card4))

        // Assert:
        cards.isBust() shouldBe true
    }
})
