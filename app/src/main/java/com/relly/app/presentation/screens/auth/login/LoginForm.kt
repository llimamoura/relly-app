package com.relly.app.presentation.screens.auth.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.composables.icons.lucide.LockKeyhole
import com.composables.icons.lucide.Lucide
import com.composables.icons.lucide.Mail
import com.relly.app.presentation.screens.auth.login.components.TopRightDecoration
import com.relly.app.presentation.screens.components.MainButtonComponent
import com.relly.app.presentation.screens.components.RellyTextField

@Composable
fun LoginForm(
    onLogin: (email: String, password: String) -> Unit = { _, _ -> },
    onNavigateToRegister: () -> Unit = {},
    errorMessage: String? = null,
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val focusManager = LocalFocusManager.current

    Box(modifier = Modifier.fillMaxSize()) {
        TopRightDecoration(
            modifier = Modifier
                .size(width = 180.dp, height = 160.dp)
                .align(Alignment.TopEnd)
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 90.dp, horizontal = 22.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Column {
                Text(
                    text = "Entrar",
                    style = MaterialTheme.typography.headlineLarge,
                    color = MaterialTheme.colorScheme.secondary,
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "Acesse para acompanhar as finanças do seu grupo.",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.secondary,
                )
            }

            Column {
                RellyTextField(
                    value = email,
                    onValueChange = { email = it },
                    placeholder =  "E-mail",
                    leadingIcon = Lucide.Mail,
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next,
                    onImeAction = { focusManager.moveFocus(FocusDirection.Down) },
                    modifier = Modifier.fillMaxWidth(),
                )

                Spacer(modifier = Modifier.height(70.dp))

                RellyTextField(
                    value = password,
                    onValueChange = { password = it },
                    placeholder = "Senha",
                    leadingIcon = Lucide.LockKeyhole,
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done,
                    onImeAction = { onLogin(email, password) },
                    isPassword = true,
                    modifier = Modifier.fillMaxWidth(),
                )

                if (errorMessage != null) {
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = errorMessage,
                        color = MaterialTheme.colorScheme.error,
                        style = MaterialTheme.typography.bodySmall,
                    )
                }
            }

            MainButtonComponent(
                text = "Entrar",
                onClick = { onLogin(email, password) },
                color = MaterialTheme.colorScheme.primary,
                colorText = MaterialTheme.colorScheme.onPrimary,
            )
        }
    }
}
