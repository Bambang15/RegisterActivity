package com.example.registeractivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var editName : EditText? = null
    var spinnnerGender : Spinner? = null
    var editEmail : EditText? = null
    var editTelp : EditText? = null
    var editAlamat : EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editName = findViewById(R.id.editnama)
        spinnnerGender = findViewById (R.id.spinergender)
        editEmail = findViewById(R.id.editemail)
        editTelp = findViewById(R.id.edittelp)
        editAlamat = findViewById(R.id.editalamat)

            button.setOnClickListener{
            validasiinput()
        }
        setDataSpinner()
    }
    fun setDataSpinner(){
        val adapter = ArrayAdapter.createFromResource(this ,R.array.gender_list,android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnnerGender?.adapter=adapter
    }
    fun validasiinput(){
        val namaInput : String = editName?.text.toString()
        val emailInput : String = editEmail?.text.toString()
        val telpInput : String = editTelp?.text.toString()
        val alamatInput : String = editAlamat?.text.toString()
        val genderinput : String = spinnnerGender?.selectedItem.toString()
        when{
            genderinput.equals("Pilih Jenis Kelamin")->
                Toast.makeText(this, "Data valid",Toast.LENGTH_SHORT).show()
            namaInput.isEmpty() -> editName?.error = "Nama belum diisi"
            emailInput.isEmpty() -> editEmail?.error = "Email belum diisi"
            telpInput.isEmpty() -> editTelp?.error = "Telepon belum diisi"
            alamatInput.isEmpty() -> editAlamat?.error = "Alamat belum diisi"

            else ->{
                Toast.makeText(this,"Data Telah Berhasil Dikirim",Toast.LENGTH_SHORT).show()
            }
        }
    }

}
