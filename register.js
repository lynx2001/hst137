document.addEventListener("DOMContentLoaded", () => {
    const form = document.querySelector(".register-form");

    form.addEventListener("submit", async (event) => {
        event.preventDefault(); // 기본 동작 막기 (페이지 새로고침 방지)

        const formData = new FormData(form);
        const data = {
            name: formData.get("name"),
            area: formData.get("area"),
            pushPull: formData.get("pushPull"),
            repMaxLightWeight: parseInt(formData.get("lightWeight"), 10) || 0,
            repMaxLightReps: parseInt(formData.get("lightReps"), 10) || 0,
            repMaxHeavyWeight: parseInt(formData.get("heavyWeight"), 10) || 0,
            repMaxHeavyReps: parseInt(formData.get("heavyReps"), 10) || 0,
            tool: formData.get("tool"),
            alternation: formData.get("alternation") === "on",
        };

        console.log("Form Data Sent:", JSON.stringify(data));

        try {
            const response = await fetch("http://localhost:8080/exercise", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify(data),
            });

            console.log("Response Status:", response.status);

            if (response.ok) {
                alert("!! 운동이 성공적으로 등록되었습니다 !!");
                form.reset();
                window.location.href = "index.html";
            } else {
                alert("오류: 운동 등록 실패");
            }
        } catch (err) {
            alert("서버와 통신 중 문제가 발생했습니다: " + err.message);
            console.error("Error:", err);
        }
    });
});
