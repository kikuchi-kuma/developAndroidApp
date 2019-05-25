package youngs.step.study.android.scoresupporter

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_match_configuration.*

//学習用メモ
//現在はActivity単位で遷移させているが、Fragment等も使用した方がいいかもしれない

class MatchConfigurationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_match_configuration)

        // spinner1要素を変数に代入
        val spinnerSet = arrayOf("1","3","5")
        // spinner1を定義
        val spinner1 = findViewById<Spinner>(R.id.spinner1)

        // spinner2要素を変数に代入
        val spinnerGame = arrayOf("1","3","5","7","9","11")
        // spinner2を定義
        val spinner2 = findViewById<Spinner>(R.id.spinner2)

        //ラジオグループ要素を変数に代入
        val radioGroup1 = findViewById<RadioGroup>(R.id.radiogroup001)

        //ラジオボタン（シングルス）をチェック状態（デフォルト）
        radioButton1.setChecked(true);

        //ラジオボタン選択時の処理
        radioGroup1?.setOnCheckedChangeListener { group, checkedId ->
            if(R.id.radioButton1 == checkedId) {
                Log.d("MatchConAct: onCreate", "シングルス")
            }
            else {
                Log.d("MatchConAct: onCreate", "ダブルス")
            }
        }

        //ラジオグループ要素を変数に代入
        val radioGroup2 = findViewById<RadioGroup>(R.id.radiogroup002)

        //ラジオボタン（自分）をチェック状態（デフォルト）
        radioButton3.setChecked(true);

        //ラジオボタン選択時の処理
        radioGroup2?.setOnCheckedChangeListener { group, checkedId ->
            if(R.id.radioButton2 == checkedId) {
                Log.d("MatchConAct: onCreate", "自分")
            }
            else {
                Log.d("MatchConAct: onCreate", "相手")
            }
        }

        // 「前の画面に戻る」ボタンを設定
        val prevButton = findViewById<Button>(R.id.prev) as Button
        // 「次へ」ボタンを設定
        val nextButton = findViewById<Button>(R.id.next) as Button

        //ArrayAdapter1に設定
        val arrayAdapter1 = ArrayAdapter(this,android.R.layout.simple_spinner_item,spinnerSet)
        spinner1.adapter = arrayAdapter1

        spinner1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            // Spinner クリックイベント（何も選択されていない時の動作）
            override fun onNothingSelected(parent: AdapterView<*>) {
                // Code to perform some action when nothing is selected
            }

            // Spinner クリックイベント（クリック時の動作）
            override fun onItemSelected(p0: AdapterView<*>, p1: View, p2: Int, p3: Long) {
                // Toast.makeText(this@MatchConfigurationActivity, spinnerMatch[p2], LENGTH_LONG).show()
            }

        }

        //ArrayAdapter2に設定
        val arrayAdapter2 = ArrayAdapter(this,android.R.layout.simple_spinner_item,spinnerGame)
        spinner2.adapter = arrayAdapter2

        spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            // Spinner クリックイベント（何も選択されていない時の動作）
            override fun onNothingSelected(parent: AdapterView<*>) {
                // Code to perform some action when nothing is selected
            }

            // Spinner クリックイベント（クリック時の動作）
            override fun onItemSelected(p0: AdapterView<*>, p1: View, p2: Int, p3: Long) {
                // Toast.makeText(this@MatchConfigurationActivity, spinnerGame[p2], LENGTH_LONG).show()
            }

        }

        //prevButtton　クリックイベント(クリック時の動作)
        prevButton.setOnClickListener {

            //「前の画面に戻る」ボタン遷移時にDebugログを出力させる
            // tagは23文字以内で設定
            Log.d("MatchConfiguration", "prevButton Clicked!")

            //MainActivityに遷移(MatchConfigurationActivityを終了)
            finish()
        }

        //nextButtton　クリックイベント(クリック時の動作)
        nextButton.setOnClickListener {

            //「次へ」ボタン遷移時にDebugログを出力させる
            // tagは23文字以内で設定
            Log.d("MatchConfiguration", "nextButton Clicked!")

            //spinner1から現在の値を取得
            val item = spinner1.selectedItem as String
            //radioGroup1から現在の値を取得
            val item2 = radioGroup1.checkedRadioButtonId

            //シングルスである場合、PlayrinutSinglesActivityに遷移
            if(item2 == R.id.radioButton1){
                val intent = Intent(this, PlayerInputSinglesActivity::class.java)
                startActivity(intent)
            }
            //ダブルスである場合、PlayrinutDoublesActivityに遷移
            else {
                val intent = Intent(this, PlayerInputDoublesActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
