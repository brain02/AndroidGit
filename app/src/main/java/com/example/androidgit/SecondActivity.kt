package com.example.androidgit

import android.os.*
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException
import java.sql.Statement
import java.util.Properties

open class SecondActivity() : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        setTitle(intent.getStringExtra("text"))

        //init object
        val btnConDB = findViewById<Button>(R.id.btnConDB)


        btnConDB.setOnClickListener {
            MyTask().execute()
            MyTask().cancel(true)
            Log.i("ConDB1","")
        }
    }


    private class MyTask : AsyncTask<Void?, Void?, Void?>() {
        var connectStates = false
        val editHost = "mensa.lite-host.in"
        val editDBName = "hlojmbez_itb"
        private var username = "hlojmbez_itb"
        private var password = "lite892083250db!"
        var url = "jdbc:mysql://" + editHost + "/" + editDBName
        var dbq_result = ""
        var queryAutho = "SELECT login FROM users"



        override fun doInBackground(vararg p0: Void?): Void? {
            try {
                Class.forName("com.mysql.jdbc.Driver")
                var connection: Connection = DriverManager.getConnection(url, username, password)
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
                    }
                }
            } catch (e: ClassNotFoundException) {
                Log.i("ConDB", "No driver")
            } catch (e: SQLException) {
                Log.i("ConDB", "No connect")
            }
            return null
        }

        override fun onProgressUpdate(vararg values: Void?) {
            super.onProgressUpdate(*values)
        }


        override fun onPostExecute(aVoid: Void?) {
            super.onPostExecute(aVoid)
            if (connectStates){
                Log.i("ConDB", "$dbq_result")
            } else{
                Log.i("ConDB", "No result")
            }
            connectStates = false
        }
    }
}


