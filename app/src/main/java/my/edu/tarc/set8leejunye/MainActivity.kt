package my.edu.tarc.set8leejunye

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val ageGroup = findViewById<Spinner>(R.id.spinnerAgeGroup)
        val salaryInput = findViewById<TextView>(R.id.textViewSalaryInput)
        val employeeContribute = findViewById<TextView>(R.id.textViewEmplyCon)
        val employerContribute = findViewById<TextView>(R.id.textViewEmplyerCon)
        val buttonCalculate = findViewById<Button>(R.id.buttonCalculate)
        val buttonReset = findViewById<Button>(R.id.buttonReset)
        val buttonSupport = findViewById<Button>(R.id.buttonSupport)
        val textViewCatBelong = findViewById<TextView>(R.id.textViewCatBelong)

        buttonCalculate.setOnClickListener {

            var employeeContribution = employeeContribute.text.toString().toDouble()
            var employerContribution = employerContribute.text.toString().toDouble()
            var textViewCatBelong = textViewCatBelong.text.toString()


            if (ageGroup.selectedItemPosition == 0){

                employeeContribution = 0.005
                employerContribution = 0.0175
                textViewCatBelong = getString(R.string.first)
            }
            if (ageGroup.selectedItemPosition == 1){

                employeeContribution = 0.00
                employerContribution = 0.0125
                textViewCatBelong = getString(R.string.Second)
            }


            if (salaryInput.text.isEmpty()){
                salaryInput.setError("Value Required")
                return@setOnClickListener
            }

            val salaryInput = salaryInput.text.toString().toDouble()
            var employeeContribute = salaryInput * employeeContribution
            var employerContribute = salaryInput * employerContribution



        }

        buttonSupport.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW,Uri.parse("https://perkeso.gov.my"))
        }

        buttonReset.setOnClickListener {
            salaryInput.setText("")
            employeeContribute.setText("")
            employerContribute.setText("")

        }

    }
}