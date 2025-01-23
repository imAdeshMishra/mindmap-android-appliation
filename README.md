# Mental Wellness Android Application

<!DOCTYPE html>
<html>
<head>
    <title>Mental Wellness Android Application</title>
</head>
<body>
    <h1>Mental Wellness Android Application</h1>
    <h2>Overview</h2>
    <p>
        This project is a comprehensive mental wellness application built from scratch. 
        It aims to promote mental health by connecting users with therapists for appointments 
        and offering curated courses to improve mental well-being. The application is user-friendly, 
        efficient, and follows modern software development practices.
    </p>

    <h2>Features</h2>
    <ul>
        <li><b>Therapist Connections:</b> Users can browse and connect with licensed therapists for online appointments.</li>
        <li><b>Mental Health Courses:</b> A variety of courses designed to help users improve their mental health and manage stress effectively.</li>
        <li><b>User-Friendly Interface:</b> Developed using Jetpack Compose for an intuitive and responsive UI.</li>
        <li><b>Secure Backend:</b> Built using Spring Boot with PostgreSQL as the database, ensuring robust data handling and security.</li>
        <li><b>MVVM Architecture:</b> Implements MVVM for clean code structure and ease of maintainability.</li>
    </ul>

    <h2>Technologies Used</h2>
    <h3>Frontend</h3>
    <ul>
        <li><b>Jetpack Compose:</b> For building the UI.</li>
        <li><b>MVVM Architecture:</b> Ensures separation of concerns and scalability.</li>
    </ul>

    <h3>Backend</h3>
    <ul>
        <li><b>Spring Boot:</b> Handles the server-side logic.</li>
        <li><b>PostgreSQL:</b> Database for storing user and therapist data.</li>
        <li><b>Hibernate:</b> ORM for database communication.</li>
    </ul>

    <h3>Communication</h3>
    <ul>
        <li><b>Retrofit:</b> Used for seamless communication between the Android app and backend APIs.</li>
    </ul>

    <h2>Setup Instructions</h2>
    <h3>Prerequisites</h3>
    <ol>
        <li>Android Studio (Latest version).</li>
        <li>Java 17 or higher.</li>
        <li>PostgreSQL installed and configured.</li>
    </ol>

    <h3>Steps to Run</h3>
    <ol>
        <li><b>Clone the repository:</b>
            <pre><code>git clone https://github.com/imAdeshMishra/mindmap-android-appliation</code></pre>
        </li>
        <li><b>Set up the backend:</b>
            <ul>
                <li>Navigate to the backend folder.</li>
                <li>Update the <code>application.properties</code> file with your PostgreSQL credentials.</li>
                <li>Build and run the Spring Boot application.</li>
            </ul>
        </li>
        <li><b>Set up the Android app:</b>
            <ul>
                <li>Open the project in Android Studio.</li>
                <li>Sync the Gradle files.</li>
                <li>Build and run the app on an emulator or a physical device.</li>
            </ul>
        </li>
    </ol>

    <h2>Including Screenshots</h2>
    <p>
        To include screenshots of the application in the README file:
        <ol>
            <li>Place your screenshots in the repository (e.g., in a folder named <code>screenshots</code>).</li>
            <li>Use the following syntax to embed the images:</li>
        </ol>
    </p>
    <pre><code>&lt;img src=&quot;screenshots/home_screen.png&quot; alt=&quot;Home Screen&quot;&gt;</code></pre>

    <h2>Example Screenshots</h2>
    <img src="screenshots/home_screen.png" alt="Home Screen">
    <p><i>Description: The home screen showcasing available courses and therapist options.</i></p>

    <img src="screenshots/therapist_connection.png" alt="Therapist Connection">
    <p><i>Description: Interface for connecting with therapists.</i></p>

    <h2>Future Enhancements</h2>
    <ul>
        <li>Add support for video consultations with therapists.</li>
        <li>Expand course offerings with multilingual support.</li>
        <li>Integrate analytics to provide users with progress tracking.</li>
    </ul>

    <h2>Contributing</h2>
    <p>
        Contributions are welcome! Please follow these steps:
        <ol>
            <li>Fork the repository.</li>
            <li>Create a new branch for your feature or bug fix.</li>
            <li>Submit a pull request with a detailed description of the changes.</li>
        </ol>
    </p>

    <h2>License</h2>
    <p>
        This project is licensed under the MIT License. See the LICENSE file for details.
    </p>
</body>
</html>
