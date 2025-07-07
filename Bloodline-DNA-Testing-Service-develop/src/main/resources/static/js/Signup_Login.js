/* script.js - Xử lý logic đăng nhập & đăng ký */

document.addEventListener("DOMContentLoaded", () => {
    const loginForm = document.getElementById("login-form");
    const registerForm = document.getElementById("register-form");
    const switchToRegister = document.getElementById("switch-to-register");
    const switchToLogin = document.getElementById("switch-to-login");
    const formTitle = document.getElementById("form-title");

    // Chuyển sang form đăng ký
    switchToRegister.addEventListener("click", (e) => {
        e.preventDefault();
        loginForm.style.display = "none";
        registerForm.style.display = "block";
        formTitle.textContent = "Sign up";
    });

    // Chuyển sang form đăng nhập
    switchToLogin.addEventListener("click", (e) => {
        e.preventDefault();
        registerForm.style.display = "none";
        loginForm.style.display = "block";
        formTitle.textContent = "Log in";
    });

    // Xử lý đăng ký
    registerForm.addEventListener("submit", async (e) => {
        e.preventDefault();
        const username = document.getElementById("register-username").value;
        const email = document.getElementById("register-email").value;
        const password = document.getElementById("register-password").value;

        if (username === "" || email === "" || password === "") {
            alert("Vui lòng điền đầy đủ thông tin!");
            return;
        }

        const user = { username, email, password };

        try {
            const response = await fetch("/api/register", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(user)
            });

            const result = await response.text();
            alert(result);

            if (result.includes("successful")) {
                // Chuyển sang form login nếu đăng ký thành công
                registerForm.style.display = "none";
                loginForm.style.display = "block";
                formTitle.textContent = "Log in";
            }
        } catch (error) {
            alert("Lỗi khi đăng ký: " + error.message);
        }
    });

    // Xử lý đăng nhập
    loginForm.addEventListener("submit", async (e) => {
        e.preventDefault();
        const username = document.getElementById("login-username").value;
        const password = document.getElementById("login-password").value;

        if (username === "" || password === "") {
            alert("Vui lòng nhập username và password!");
            return;
        }

        const user = { username, password };

        try {
            const response = await fetch("/api/login", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(user)
            });

            const result = await response.text();
            alert(result);

            if (result.includes("thanh cong")) {
                localStorage.setItem("username", username);
                window.location.href = "/";
            }
        } catch (error) {
            alert("Lỗi khi đăng nhập: " + error.message);
        }
    });
});
