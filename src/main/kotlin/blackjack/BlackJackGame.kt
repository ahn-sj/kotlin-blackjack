package blackjack

import blackjack.card.Deck
import blackjack.participant.Dealer
import blackjack.participant.Player
import blackjack.participant.Players
import blackjack.policy.InputMoreCardPolicy
import blackjack.view.OutputView

data class BlackJackGame(
    val dealer: Dealer,
    val gamePlayers: Players,
    val turnMachine: TurnMachine,
) {
    fun play(): List<ParticipantResult> {
        gamePlayers.players.forEach { player -> turnMachine.playerTurn(player) }
        turnMachine.dealerTurn(dealer)

        return ParticipantResult.of(dealer, gamePlayers)
    }

    companion object {
        fun start(
            dealer: Dealer,
            players: List<Player>,
            deck: Deck,
        ): BlackJackGame {
            dealer.take(listOf(deck.pick(), deck.pick()))
            players.forEach { player -> player.take(listOf(deck.pick(), deck.pick())) }

            return BlackJackGame(
                dealer,
                Players(players),
                TurnMachine(deck, InputMoreCardPolicy, OutputView),
            )
        }
    }
}
