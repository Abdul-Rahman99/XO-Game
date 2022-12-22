package com.example.xogame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.xogame.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
         binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }

    fun buSelect(view: View) {
        val buChoice = view as Button
        var cellID = 0
        when (buChoice.id) {
            R.id.bu1 -> cellID = 1
            R.id.bu2 -> cellID = 2
            R.id.bu3 -> cellID = 3
            R.id.bu4 -> cellID = 4
            R.id.bu5 -> cellID = 5
            R.id.bu6 -> cellID = 6
            R.id.bu7 -> cellID = 7
            R.id.bu8 -> cellID = 8
            R.id.bu9 -> cellID = 9
        }
        Log.d("cell ID : ", cellID.toString())
        playGame(cellID, buChoice)
    }

    private var player1 = ArrayList<Int>()
    private var player2 = ArrayList<Int>()
    private var activePlayer = 1

    private fun playGame(cellID: Int, buChoice: Button) {
        Log.d("A" , "playGame")
        if (activePlayer == 1) {
            buChoice.text = "X"
            buChoice.setBackgroundResource(R.color.purple_200)
            player1.add(cellID)
            activePlayer = 2
            autoPlay()
        } else {
            buChoice.text = "O"
            buChoice.setBackgroundResource(R.color.teal_700)
            player2.add(cellID)
            activePlayer = 1
        }
        buChoice.isEnabled = false
        checkWinner()
    }

    private fun checkWinner() {
        var winner = -1


        // rows
        // row 1 playing
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winner = 2
        }

        // row 2 playing
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winner = 1
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winner = 2
        }

        // row 3 playing
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winner = 2
        }

        // columns
        // column 1 playing
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winner = 2
        }

        // column 2 playing
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winner = 1
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winner = 2
        }

        // column 3 playing
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winner = 2
        }

        // xxx
        // xxx 1 playing
        if (player1.contains(1) && player1.contains(5) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(5) && player2.contains(9)) {
            winner = 2
        }

        // xxx 2 playing
        if (player1.contains(3) && player1.contains(5) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(3) && player2.contains(5) && player2.contains(9)) {
            winner = 2
        }

        // showing the winner returns to the main function
        if (winner != -1) {
            if (winner == 1) {
                Toast.makeText(this, "The winner is number 1", Toast.LENGTH_LONG).show()

            } else {
                Toast.makeText(this, "The winner is number 2", Toast.LENGTH_LONG).show()
            }
//            finish()
        }
    }


    private fun autoPlay() {
        Log.d("A" , "autoPlay")
        // Scanning for empty cells
        val emptyCells = ArrayList<Int>()
        for (cellID in 1..9) {
            if (!(player1.contains(cellID) || player2.contains(cellID))) {
                emptyCells.add(cellID)
            }
        }

        // selecting random indexes
        val r = java.util.Random()
        val randIndex = r.nextInt(emptyCells.size - 0) +0
        val cellIDs = emptyCells[randIndex]

        // interpreter index to button
        val btn: Button?
        when (cellIDs) {
            1 -> btn = binding.bu1
            2 -> btn = binding.bu2
            3 -> btn = binding.bu3
            4 -> btn = binding.bu4
            5 -> btn = binding.bu5
            6 -> btn = binding.bu6
            7 -> btn = binding.bu7
            8 -> btn = binding.bu8
            9 -> btn = binding.bu9
            else -> {
                btn = binding.bu1
            }
        }
        playGame(cellIDs, btn)
    }

}










