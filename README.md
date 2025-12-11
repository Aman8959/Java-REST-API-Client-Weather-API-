# Java-REST-API-Client-Weather-API-
This program fetches live weather data for Satna, Madhya Pradesh, using the Open-Meteo API and displays the result as Temperature, Wind Speed, and Time.

🎯 Features
✔ Fetches live weather data using a public REST API
✔ Uses HttpURLConnection (built-in Java class)
✔ Extracts and parses weather details (temperature, windspeed, time)
✔ Displays structured, human-readable weather report
✔ No external libraries required
✔ Fully commented and beginner-friendly

🏗️ Technologies Used

Java (JDK 8 or above)

REST API (Open-Meteo)

HttpURLConnection

Regular Expressions (Regex) for JSON parsing

📍 Weather Source (Open-Meteo API)

Coordinates for Satna (M.P.):

Latitude: 24.60

Longitude: 80.85

API URL used:

https://api.open-meteo.com/v1/forecast?latitude=24.60&longitude=80.85&current_weather=true

📂 Project Structure
WeatherAPIClient/
│
├── WeatherAPIClientSatna.java   → Main Java file
├── README.md                    → Project documentation

🔧 How the Program Works
1️⃣ Calls REST API

Uses HttpURLConnection to send an HTTP GET request.

2️⃣ Receives JSON Response

Example (simplified):

{
  "current_weather": {
    "temperature": 29.4,
    "windspeed": 8.5,
    "time": "2025-12-11T09:00"
  }
}

3️⃣ Extracts Required Details

Temperature (°C)

Wind Speed (km/h)

Time (ISO format)

4️⃣ Displays Structured Output

Example:

🌦️ WEATHER REPORT – SATNA (M.P.)
------------------------------------
Temperature : 29.4 °C
Wind Speed  : 8.5 km/h
Time        : 2025-12-11T09:00
------------------------------------

▶️ How to Run the Program
Step 1 — Save file as
WeatherAPIClientSatna.java

Step 2 — Compile
javac WeatherAPIClientSatna.java

Step 3 — Run
java WeatherAPIClientSatna

🧪 Sample Output
🌦️ WEATHER REPORT – SATNA (M.P.)
------------------------------------
Temperature : 29.3 °C
Wind Speed  : 8.5 km/h
Time        : 2025-12-11T09:00
------------------------------------



