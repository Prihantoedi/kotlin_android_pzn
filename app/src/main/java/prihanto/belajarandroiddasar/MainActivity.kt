package prihanto.belajarandroiddasar

import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {

    private lateinit var nameEditText: EditText
    private lateinit var sayHelloButton: Button
    private lateinit var sayHelloTextView: TextView

    private fun initComponents(){
        nameEditText = findViewById(R.id.nameEditText)
        sayHelloButton = findViewById(R.id.sayHelloButton)
        sayHelloTextView = findViewById(R.id.sayHelloTextView)
    }

    private fun checkFingerPrint(){
        if(packageManager.hasSystemFeature(PackageManager.FEATURE_FINGERPRINT)){
            Log.i("FEATURE", "Feature Fingerprint ON")
        } else{
            Log.w("FEATURE", "Feature Fingerprint OFF")
        }
    }

    private fun checkPlatformVersion(){
        Log.i("SDK", Build.VERSION.SDK_INT.toString())
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.S){
            Log.i("SDK", "Disabled feature, because version sdk is lower than 31")
        }
    }

    private fun printHello(name: String){
        Log.i("DEBUG", name)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        setContentView(R.layout.hello_world)

        initComponents()

        sayHelloTextView.text = resources.getString(R.string.app_name)

        sayHelloButton.setOnClickListener {

            val firstName = "Prihanto"
            printHello(firstName)
            checkPlatformVersion()
            checkFingerPrint()
            val sample = resources.openRawResource(R.raw.sample)
                .bufferedReader()
                .use { it.readText() }

            Log.i("RAW", sample)

            val json = assets.open("sample.json")
                .bufferedReader()
                .use{ it.readText() }

            Log.i("ASSET", json)

//            resources.getDrawable(R.drawable.crown, theme)

            Log.d("PES", "This is debug log")
            Log.i("PES", "This is info log")
            Log.w("PES", "This is warn log")
            Log.e("PES", "This is error log")

            Log.i("ValueResource", resources.getInteger(R.integer.maxPage).toString())
            Log.i("ValueResource", resources.getBoolean(R.bool.isProductionMode).toString())
            Log.i("ValueResource", resources.getIntArray(R.array.numbers).joinToString(","))
            Log.i("ValueResource", resources.getColor(R.color.background, theme).toString())

            sayHelloButton.setBackgroundColor(resources.getColor(R.color.background, theme))

            val name = nameEditText.text.toString()
//            sayHelloTextView.text = "Hi $name"
//            example without hardcode, it means it obatin from the strings resource:
            sayHelloTextView.text = resources.getString(R.string.sayHelloTextView, name)

            resources.getStringArray(R.array.myNames).forEach{
                Log.i("PES", it)
            }
        }
    }
}