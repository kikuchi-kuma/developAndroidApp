package youngs.step.study.android.scoresupporter

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

//学習用メモ
//AndroidではIntentという機能で画面遷移を行う
//Intentとはactivity間で情報のやり取りをするための箱である
//横画面にするとレイアウトが崩れるため、現時点では全て縦画面固定

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 「試合を記録する」ボタンを設定
        val matchRecordButton = findViewById<Button>(R.id.matchrecord) as Button
        // 「過去データ」ボタンを設定
        val pastDataButton = findViewById<Button>(R.id.pastdata) as Button

        //matchRecordButtton　クリックイベント(クリック時の動作)
        matchRecordButton.setOnClickListener {

            //「試合を記録する」ボタン押下時にDebugログを出力させる
            Log.d("MainActivity", "matchRecordButton Clicked!")

            //MatchConfigurationActivityに遷移
            val intent = Intent(this, MatchConfigurationActivity::class.java)
            startActivity(intent)

        }

        //pastDataButton　クリックイベント(クリック時の動作)
        pastDataButton.setOnClickListener {

            //「過去データ」ボタン押下時にDebugログを出力させる
            Log.d("MainActivity", "pastDataButton Clicked!")

            //次のActivityに遷移

        }
    }
}
