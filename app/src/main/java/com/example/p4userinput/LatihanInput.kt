package com.example.p4userinput

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun LatihanInput(
    modifier: Modifier = Modifier
) {
    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var notelpon by remember { mutableStateOf("") }

    val dataGender = listOf("Laki-Laki", "Perempuan")
    var selectedGender by remember { mutableStateOf(dataGender[0]) }

    var confNama by remember { mutableStateOf("") }
    var confEmail by remember { mutableStateOf("") }
    var confAlamat by remember { mutableStateOf("") }
    var confNotelpon by remember { mutableStateOf("") }
    var confGender by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = nama,
            onValueChange = { nama = it },
            label = { Text(text = "Nama") },
            placeholder = { Text(text = "Isi Nama Anda") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )


        Text(text = "Jenis Kelamin:")
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth().padding(5.dp)
        ) {
            dataGender.forEach { genderOption ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(horizontal = 8.dp)
                ) {
                    RadioButton(
                        selected = (genderOption == selectedGender),
                        onClick = { selectedGender = genderOption }
                    )
                    Text(text = genderOption, modifier = Modifier.padding(start = 4.dp))
                }
            }
        }

        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text(text = "Email") },
            placeholder = { Text(text = "Isi Email Anda") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        TextField(
            value = alamat,
            onValueChange = { alamat = it },
            label = { Text(text = "Alamat") },
            placeholder = { Text(text = "Isi Alamat Anda") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        TextField(
            value = notelpon,
            onValueChange = { notelpon = it },
            label = { Text(text = "No Telepon") },
            placeholder = { Text(text = "Isi No Telepon Anda") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Button(
            onClick = {
                confNama = nama
                confEmail = email
                confAlamat = alamat
                confNotelpon = notelpon
                confGender = selectedGender
            },
            modifier = Modifier.padding(5.dp)
        ) {
            Text(text = "Simpan")
        }

        // Menampilkan data setelah tombol Simpan ditekan
        TampilData(param = "Nama", argu = confNama)
        TampilData(param = "Email", argu = confEmail)
        TampilData(param = "Alamat", argu = confAlamat)
        TampilData(param = "No Telepon", argu = confNotelpon)
        TampilData(param = "Gender", argu = confGender)
    }
}

@Composable
fun TampilData(
    param: String,
    argu: String
) {
    Column(
        modifier = Modifier.padding(8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = "$param:",
                modifier = Modifier.weight(1f)
            )
            Text(
                text = argu,
                modifier = Modifier.weight(2f)
            )
        }
    }
}
