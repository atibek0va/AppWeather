I first get the weather API from the internet. 
It  fetches data from the OpenWeatherMap API in the
background. The doInBackground method orchestrates 
the HTTP request to the OpenWeatherMap API, 
incorporating the provided city, country, and API key.
The JSON response is then processed in the 
nPostExecute method, extracting essential weather 
details such as temperature, description, humidity, 
and wind speed. Furthermore, the temperature values 
are converted from Kelvin to Celsius to enhance user
readability. Finally, the formatted weather data is
exhibited in the designated TextView, enabling users
to conveniently access current weather information 
for their selected location.