package com.example.androidgit

import android.content.Context
import android.os.AsyncTask
import android.os.Build
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Website.URL
import android.util.Log
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException
import java.sql.Statement

class SecondActivity : AppCompatActivity() {

    private var URL : String = ""
    private var UserName = "hlojmbez_itb"
    private var Password = "lite892083250db!"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        setTitle(intent.getStringExtra("text"))

        //init object
            val btnConDB = findViewById<Button>(R.id.btnConDB)
        //init Connection
            val editHost ="mensa.lite-host.in"
            val editDBName = "hlojmbez_itb"
            val editUserName = "hlojmbez_itb"
            val editPass = "lite892083250db!"

        btnConDB.setOnClickListener {

            MyTask().execute()
            //hideKeyboard()
        }
    }

    //скрыть клаву
    fun hideKeyboard() {
        val view = this.currentFocus
        if(view != null){
            val hideMe = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            hideMe.hideSoftInputFromWindow(view.windowToken, 0)
        }
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
    }

    // Обработка запроса


    private class MyTask : AsyncTask<Void?, Void?, Void?>() {
        var connectStates = false
        var dbq_result = ""
        var textResult = ""
        var queryAutho = "SELECT login FROM users"
        val editHost ="mensa.lite-host.in"
        val editDBName = "hlojmbez_itb"
        var URL = "jdbc:mysql://" + editHost+ "/" + editDBName
        private var UserName = "hlojmbez_itb"
        private var Password = "lite892083250db!"


        override fun doInBackground(vararg p0: Void?): Void? {
            try {
                Class.forName("com.mysql.jdbc.Driver")
                var connection: Connection = DriverManager.getConnection(URL, UserName, Password)
                var statement: Statement = connection.createStatement()
                if (!connection.isClosed()) {
                    Log.i("ConDB", "Connect")
                    connectStates = true

                    // выбираем данные с БД
                    val rs = statement.executeQuery(queryAutho)
                    while (rs.next()) {
                        val db_users = rs.getString("login")
                        dbq_result += """
                        $db_users
                        
                        """.trimIndent()
                        // Создание LayoutParams c шириной и высотой по содержимому
                    }
                }
            } catch (e: ClassNotFoundException) {
                Log.i("ConDB", "No driver")
            } catch (e: SQLException) {
                Log.i("ConDB", "No connect1")
            }
            return null
        }

        override fun onProgressUpdate(vararg values: Void?) {
            super.onProgressUpdate(*values)
        }


        override fun onPostExecute(aVoid: Void?) {
            super.onPostExecute(aVoid)
            textResult = dbq_result
            if (connectStates) {
                Log.i("ConDB", " connect")
            } else {
                Log.i("ConDB", "No connect2")
            }
            connectStates = false
        }
    }

}



