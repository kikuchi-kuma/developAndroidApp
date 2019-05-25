package youngs.step.study.android.scoresupporter

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

const val DOUBLES_CODE = 2

class PlayerInputDoublesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player_input_doubles)

        //「自分の名前1」テキストを設定
        val player1Text = findViewById<EditText>(R.id.dou_myplayer1) as EditText
        //「自分の名前2」テキストを設定
        val player2Text = findViewById<EditText>(R.id.dou_myplayer2) as EditText
        //「相手の名前1」テキストを設定
        val player3Text = findViewById<EditText>(R.id.dou_oppplayer1) as EditText
        //「相手の名前2」テキストを設定
        val player4Text = findViewById<EditText>(R.id.dou_oppplayer2) as EditText

        // 「前の画面に戻る」ボタンを設定
        val prevButton = findViewById<Button>(R.id.prev) as Button
        // 「入力完了」ボタンを設定
        val nextButton = findViewById<Button>(R.id.next) as Button

        //prevButtton　クリックイベント(クリック時の動作)
        prevButton.setOnClickListener {

            //「前の画面に戻る」ボタン遷移時にDebugログを出力させる
            // tagは23文字以内で設定
            Log.d("PlayerInputDoubles", "prevButton Clicked!")

            //MainActivityに遷移(MatchConfigurationActivityを終了)
            finish()
        }

        //nextButtton　クリックイベント(クリック時の動作)
        nextButton.setOnClickListener {

            //「入力完了」ボタン遷移時にDebugログを出力させる
            // tagは23文字以内で設定
            Log.d("PlayerInputDoubles", "nextButton Clicked!")

            //次のActivityに遷移
            //intentを設定
            val intent = Intent(this, MatchMainDoublesActivity::class.java)
            //「自分の名前1」テキストに入力された値を設定
            intent.putExtra("player1", player1Text.text.toString())
            //「自分の名前2」テキストに入力された値を設定
            intent.putExtra("player2", player2Text.text.toString())
            //「相手の名前1」テキストに入力された値を設定
            intent.putExtra("player3", player3Text.text.toString())
            //「相手の名前2」テキストに入力された値を設定
            intent.putExtra("player4", player4Text.text.toString())
            //MatchMainSinglesActivityに遷移
            startActivityForResult(intent, DOUBLES_CODE)

        }

    }
}
