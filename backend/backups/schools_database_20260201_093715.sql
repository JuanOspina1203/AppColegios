-- MySQL dump 10.13  Distrib 9.5.0, for Linux (x86_64)
--
-- Host: localhost    Database: schools_database
-- ------------------------------------------------------
-- Server version	9.5.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `schools_database`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `schools_database` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `schools_database`;

--
-- Table structure for table `books_tbl`
--

DROP TABLE IF EXISTS `books_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `books_tbl` (
  `book_id` int NOT NULL AUTO_INCREMENT,
  `book_author` varchar(255) DEFAULT NULL,
  `book_category` varchar(255) DEFAULT NULL,
  `book_name` varchar(255) DEFAULT NULL,
  `student_identification_number` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`book_id`),
  UNIQUE KEY `UKnc3j1b4cm2qtd6c6wcyh3f09e` (`student_identification_number`),
  CONSTRAINT `fk_book_student_identification` FOREIGN KEY (`student_identification_number`) REFERENCES `students_tbl` (`student_identification_number`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books_tbl`
--

LOCK TABLES `books_tbl` WRITE;
/*!40000 ALTER TABLE `books_tbl` DISABLE KEYS */;
INSERT INTO `books_tbl` VALUES (1,'Gabriel García Márquez','Ficción','Cien años de soledad',NULL),(3,'Jorge Luis Borges','Ficción','Ficciones',NULL),(4,'Julio Cortázar','Ficción','Rayuela',NULL),(5,'Isabel Allende','Ficción','La casa de los espíritus',NULL),(6,'J.R.R. Tolkien','Fantasía','El Señor de los Anillos',NULL),(7,'J.K. Rowling','Fantasía','Harry Potter y la piedra filosofal',NULL),(8,'George R.R. Martin','Fantasía','Juego de Tronos',NULL),(9,'Patrick Rothfuss','Fantasía','El nombre del viento',NULL),(10,'Brandon Sanderson','Fantasía','El camino de los reyes',NULL),(11,'Isaac Asimov','Ciencia Ficción','Fundación',NULL),(12,'Frank Herbert','Ciencia Ficción','Dune',NULL),(13,'Philip K. Dick','Ciencia Ficción','¿Sueñan los androides con ovejas eléctricas?',NULL),(14,'Arthur C. Clarke','Ciencia Ficción','2001: Una odisea espacial',NULL),(15,'Ray Bradbury','Ciencia Ficción','Fahrenheit 451',NULL),(16,'Agatha Christie','Misterio','Asesinato en el Orient Express',NULL),(17,'Dan Brown','Thriller','El código Da Vinci',NULL),(18,'Stieg Larsson','Thriller','Los hombres que no amaban a las mujeres',NULL),(19,'Gillian Flynn','Thriller','Perdida',NULL),(20,'Arthur Conan Doyle','Misterio','El sabueso de los Baskerville',NULL),(21,'Jane Austen','Romance','Orgullo y prejuicio',NULL),(22,'Nicholas Sparks','Romance','El diario de Noah',NULL),(23,'Emily Brontë','Romance','Cumbres borrascosas',NULL),(24,'John Green','Romance','Bajo la misma estrella',NULL),(25,'Jojo Moyes','Romance','Yo antes de ti',NULL),(26,'Stephen Hawking','Ciencia','Breve historia del tiempo',NULL),(27,'Yuval Noah Harari','Historia','Sapiens: De animales a dioses',NULL),(28,'Dale Carnegie','Autoayuda','Cómo ganar amigos e influir sobre las personas',NULL),(29,'Viktor Frankl','Psicología','El hombre en busca de sentido',NULL),(30,'James Clear','Autoayuda','Hábitos atómicos',NULL),(31,'Walter Isaacson','Biografía','Steve Jobs',NULL),(32,'Anne Frank','Memorias','El diario de Ana Frank',NULL),(33,'Malala Yousafzai','Biografía','Yo soy Malala',NULL),(34,'Michelle Obama','Memorias','Mi historia',NULL),(35,'Nelson Mandela','Autobiografía','El largo camino hacia la libertad',NULL),(36,'Stephen King','Terror','It (Eso)',NULL),(37,'Edgar Allan Poe','Terror','Cuentos de terror',NULL),(38,'H.P. Lovecraft','Terror','La llamada de Cthulhu',NULL),(39,'Bram Stoker','Terror','Drácula',NULL),(40,'Mary Shelley','Terror','Frankenstein',NULL),(41,'Friedrich Nietzsche','Filosofía','Así habló Zaratustra',NULL),(42,'Platón','Filosofía','La República',NULL),(43,'René Descartes','Filosofía','Discurso del método',NULL),(44,'Séneca','Filosofía','Cartas a Lucilio',NULL),(45,'Marcus Aurelius','Filosofía','Meditaciones',NULL),(46,'Suzanne Collins','Distopía','Los juegos del hambre',NULL),(47,'Veronica Roth','Distopía','Divergente',NULL),(48,'George Orwell','Distopía','1984',NULL),(49,'Aldous Huxley','Distopía','Un mundo feliz',NULL),(50,'Lois Lowry','Distopía','El dador',NULL),(51,'Miguel de Cervantes','Ficción','Don Quijote de la Mancha',NULL);
/*!40000 ALTER TABLE `books_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `directors_tbl`
--

DROP TABLE IF EXISTS `directors_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `directors_tbl` (
  `director_identification_number` varchar(255) NOT NULL,
  `director_email` varchar(255) DEFAULT NULL,
  `director_identification_type` varchar(255) DEFAULT NULL,
  `director_name` varchar(255) DEFAULT NULL,
  `director_password` varchar(255) DEFAULT NULL,
  `director_username` varchar(255) DEFAULT NULL,
  `role` enum('DIRECTOR','STUDENT','TEACHER') DEFAULT NULL,
  PRIMARY KEY (`director_identification_number`),
  UNIQUE KEY `UKpnmk4uehkvfjm3l2d0o98sxgq` (`director_username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `directors_tbl`
--

LOCK TABLES `directors_tbl` WRITE;
/*!40000 ALTER TABLE `directors_tbl` DISABLE KEYS */;
INSERT INTO `directors_tbl` VALUES ('65762617','william.ospina@colegio.com','CC','William Ospina','$2a$10$Z3aX9oxT4aCvExyUnAVEauNQnX9bG4Up9ZGb.oHJJ2IAFn0SlkdT.','wiospina','DIRECTOR');
/*!40000 ALTER TABLE `directors_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grade_groups_tbl`
--

DROP TABLE IF EXISTS `grade_groups_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `grade_groups_tbl` (
  `grade_group_id` varchar(255) NOT NULL,
  `grade_group_campus` varchar(255) DEFAULT NULL,
  `grade_group_floor_number` int DEFAULT NULL,
  `grade_group_grade_level` varchar(255) DEFAULT NULL,
  `grade_group_letter` varchar(255) DEFAULT NULL,
  `grade_group_shift` varchar(255) DEFAULT NULL,
  `grade_group_teacher_in_charge_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`grade_group_id`),
  KEY `grade_group_teacher_in_charge_id` (`grade_group_teacher_in_charge_id`),
  CONSTRAINT `grade_group_teacher_in_charge_id` FOREIGN KEY (`grade_group_teacher_in_charge_id`) REFERENCES `teachers_tbl` (`teacher_identification_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grade_groups_tbl`
--

LOCK TABLES `grade_groups_tbl` WRITE;
/*!40000 ALTER TABLE `grade_groups_tbl` DISABLE KEYS */;
INSERT INTO `grade_groups_tbl` VALUES ('10A','Sede Principal bogota',3,'10','A','NOCHE',NULL),('6A','Sede Nuestro Santo Sacramental Ibague',2,'6','A','TARDE','988790243');
/*!40000 ALTER TABLE `grade_groups_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students_tbl`
--

DROP TABLE IF EXISTS `students_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `students_tbl` (
  `student_grade` varchar(255) DEFAULT NULL,
  `student_identification_number` varchar(12) NOT NULL,
  `student_identification_type` varchar(255) DEFAULT NULL,
  `student_name` varchar(255) DEFAULT NULL,
  `student_grade_related` varchar(255) DEFAULT NULL,
  `role` enum('DIRECTOR','STUDENT','TEACHER') DEFAULT NULL,
  PRIMARY KEY (`student_identification_number`),
  UNIQUE KEY `uk_student_identification` (`student_identification_number`),
  KEY `FK7vsxj9wqrh9wjcdly0p4hg6xh` (`student_grade_related`),
  CONSTRAINT `FK7vsxj9wqrh9wjcdly0p4hg6xh` FOREIGN KEY (`student_grade_related`) REFERENCES `grade_groups_tbl` (`grade_group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students_tbl`
--

LOCK TABLES `students_tbl` WRITE;
/*!40000 ALTER TABLE `students_tbl` DISABLE KEYS */;
INSERT INTO `students_tbl` VALUES ('1A','1000012345','RC','Valentina Rodríguez',NULL,'STUDENT'),('1B','1000012346','RC','Santiago Gómez',NULL,'STUDENT'),('2A','1000012347','RC','Isabella Martínez',NULL,'STUDENT'),('2B','1000012348','RC','Mateo López',NULL,'STUDENT'),('3A','1000012349','RC','Sofía Hernández',NULL,'STUDENT'),('3B','1000012350','RC','Diego García',NULL,'STUDENT'),('4A','1000012351','RC','Camila Pérez',NULL,'STUDENT'),('4B','1000012352','RC','Nicolás Fernández',NULL,'STUDENT'),('5A','1000012353','RC','Mariana Díaz',NULL,'STUDENT'),('5B','1000012354','RC','Julián Sánchez',NULL,'STUDENT'),('6A','1000012355','TI','Lucía Ramírez',NULL,'STUDENT'),('6B','1000012356','TI','Daniel Castro',NULL,'STUDENT'),('7A','1000012357','TI','Ximena Torres',NULL,'STUDENT'),('7B','1000012358','TI','Samuel Ortiz',NULL,'STUDENT'),('8A','1000012359','TI','Valeria Silva',NULL,'STUDENT'),('8B','1000012360','TI','Miguel Mendoza',NULL,'STUDENT'),('9A','1000012361','TI','Ana Vargas',NULL,'STUDENT'),('9B','1000012362','TI','Juan Camilo Rojas',NULL,'STUDENT'),('10A','1000012363','CC','Carlos Andrés Herrera',NULL,'STUDENT'),('10B','1000012364','CC','Laura González',NULL,'STUDENT'),('1A','1000012365','RC','Alejandro Jiménez',NULL,'STUDENT'),('1B','1000012366','RC','Paula Ávila',NULL,'STUDENT'),('2A','1000012367','RC','Felipe Castro',NULL,'STUDENT'),('2B','1000012368','RC','Daniela Ríos',NULL,'STUDENT'),('3A','1000012369','RC','Jorge Luis Muñoz',NULL,'STUDENT'),('3B','1000012370','RC','Adriana Núñez',NULL,'STUDENT'),('4A','1000012371','RC','Ricardo Peña',NULL,'STUDENT'),('4B','1000012372','RC','Fernanda Delgado',NULL,'STUDENT'),('5A','1000012373','RC','Héctor Guzmán',NULL,'STUDENT'),('5B','1000012374','RC','Elena Romero',NULL,'STUDENT'),('6A','1000012375','TI','Raúl Ortega',NULL,'STUDENT'),('6B','1000012376','TI','Patricia Marín',NULL,'STUDENT'),('7A','1000012377','TI','Roberto Salazar',NULL,'STUDENT'),('7B','1000012378','TI','Tatiana Vega',NULL,'STUDENT'),('8A','1000012379','TI','Cristian Flores',NULL,'STUDENT'),('8B','1000012380','TI','Claudia Medina',NULL,'STUDENT'),('9A','1000012381','TI','Gustavo Navarro',NULL,'STUDENT'),('9B','1000012382','TI','Diana Paredes',NULL,'STUDENT'),('1A','1000012383','RC','Luis Fernando Acosta',NULL,'STUDENT'),('1B','1000012384','RC','Verónica Carrillo',NULL,'STUDENT'),('2A','1000012385','RC','Edison Franco',NULL,'STUDENT'),('2B','1000012386','RC','Liliana Ponce',NULL,'STUDENT'),('3A','1000012387','RC','Hugo Vera',NULL,'STUDENT'),('3B','1000012388','RC','Silvia Zambrano',NULL,'STUDENT'),('4A','1000012389','RC','Rafael Aguirre',NULL,'STUDENT'),('4B','1000012390','RC','Alicia Cáceres',NULL,'STUDENT'),('5A','1000012391','RC','Esteban Molina',NULL,'STUDENT'),('5B','1000012392','RC','Yolanda León',NULL,'STUDENT'),('6A','1000012393','TI','Fabian Quintero',NULL,'STUDENT'),('6B','1000012394','TI','Beatriz Valencia',NULL,'STUDENT'),('7A','1000012395','TI','Milton Parra',NULL,'STUDENT'),('7B','1000012396','TI','Rocío Méndez',NULL,'STUDENT'),('8A','1000012397','TI','Wilson Cárdenas',NULL,'STUDENT'),('8B','1000012398','TI','Olga Lozano',NULL,'STUDENT'),('9A','1000012399','TI','Pablo Escobar',NULL,'STUDENT'),('9B','1000012400','TI','Carmen Rosa Fuentes',NULL,'STUDENT'),('1A','1000012401','RC','Johan Smith',NULL,'STUDENT'),('1B','1000012402','RC','Danna Johnson',NULL,'STUDENT'),('2A','1000012403','RC','Steven Williams',NULL,'STUDENT'),('2B','1000012404','RC','Melissa Brown',NULL,'STUDENT'),('3A','1000012405','RC','Brian Jones',NULL,'STUDENT'),('3B','1000012406','RC','Vanessa Davis',NULL,'STUDENT'),('4A','1000012407','RC','Jason Miller',NULL,'STUDENT'),('4B','1000012408','RC','Stephanie Wilson',NULL,'STUDENT'),('5A','1000012409','RC','Kevin Taylor',NULL,'STUDENT'),('5B','1000012410','RC','Nicole Anderson',NULL,'STUDENT'),('6A','1000012411','TI','Brandon Thomas',NULL,'STUDENT'),('6B','1000012412','TI','Christina Jackson',NULL,'STUDENT'),('7A','1000012413','TI','Gary White',NULL,'STUDENT'),('7B','1000012414','TI','Rachel Harris',NULL,'STUDENT'),('8A','1000012415','TI','Eric Martin',NULL,'STUDENT'),('8B','1000012416','TI','Amanda Thompson',NULL,'STUDENT'),('9A','1000012417','TI','Scott Garcia',NULL,'STUDENT'),('9B','1000012418','TI','Tiffany Martinez',NULL,'STUDENT'),('1A','1000012419','RC','Eduardo Hall',NULL,'STUDENT'),('1B','1000012420','RC','Gabriela Allen',NULL,'STUDENT'),('2A','1000012421','RC','José Young',NULL,'STUDENT'),('2B','1000012422','RC','Paulina King',NULL,'STUDENT'),('3A','1000012423','RC','Manuel Wright',NULL,'STUDENT'),('3B','1000012424','RC','Elena Scott',NULL,'STUDENT'),('4A','1000012425','RC','Pedro Torres',NULL,'STUDENT'),('4B','1000012426','RC','Rosa Nguyen',NULL,'STUDENT'),('5A','1000012427','RC','Francisco Hill',NULL,'STUDENT'),('5B','1000012428','RC','Luisa Flores',NULL,'STUDENT'),('6A','1000012429','TI','Javier Green',NULL,'STUDENT'),('6B','1000012430','TI','Marta Adams',NULL,'STUDENT'),('7A','1000012431','TI','Raul Nelson',NULL,'STUDENT'),('7B','1000012432','TI','Teresa Baker',NULL,'STUDENT'),('8A','1000012433','TI','Alfonso Carter',NULL,'STUDENT'),('8B','1000012434','TI','Ruth Mitchell',NULL,'STUDENT'),('9A','1000012435','TI','Antonio Pérez',NULL,'STUDENT'),('9B','1000012436','TI','Eva Roberts',NULL,'STUDENT'),('10A','1001234567','CC','Juan Camilo Pérez',NULL,'STUDENT'),('10B','1001234568','CC','María Fernanda González',NULL,'STUDENT'),('11A','1001234569','TI','Carlos Andrés Rodríguez',NULL,'STUDENT'),('11B','1001234570','TI','Ana Sofía Martínez',NULL,'STUDENT'),('9A','1001234571','RC','Sebastián López',NULL,'STUDENT'),('9B','1001234572','RC','Valentina Sánchez',NULL,'STUDENT'),('12A','1001234573','CC','Andrés Felipe Ramírez',NULL,'STUDENT'),('12B','1001234574','CC','Isabella Torres',NULL,'STUDENT'),('10A','1001234575','TI','Mateo Herrera',NULL,'STUDENT'),('10B','1001234576','CC','Sofía Castro',NULL,'STUDENT'),('11A','1001234577','TI','Samuel Díaz',NULL,'STUDENT'),('11B','1001234578','CC','Mariana Ortega',NULL,'STUDENT'),('9A','1001234579','RC','Daniel Gómez',NULL,'STUDENT'),('9B','1001234580','RC','Gabriela Mendoza',NULL,'STUDENT'),('12A','1001234581','CC','David Jiménez',NULL,'STUDENT'),('12B','1001234582','CC','Camila Ruiz',NULL,'STUDENT'),('10A','1001234583','TI','Julián Silva',NULL,'STUDENT'),('10B','1001234584','CC','Lucía Vargas',NULL,'STUDENT'),('11A','1001234585','TI','Tomás Rojas',NULL,'STUDENT'),('11B','1001234586','CC','Antonella Flores',NULL,'STUDENT'),('9A','1001234587','RC','Emilio Reyes',NULL,'STUDENT'),('9B','1001234588','RC','Victoria Núñez',NULL,'STUDENT'),('12A','1001234589','CC','Felipe Peña',NULL,'STUDENT'),('12B','1001234590','CC','Ximena Delgado',NULL,'STUDENT'),('10A','1001234591','TI','Ricardo Morales',NULL,'STUDENT'),('10B','1001234592','CC','Daniela Suárez',NULL,'STUDENT'),('11A','1001234593','TI','Alejandro Vega',NULL,'STUDENT'),('11B','1001234594','CC','Paola Romero',NULL,'STUDENT'),('9A','1001234595','RC','Hugo Aguilar',NULL,'STUDENT'),('9B','1001234596','RC','Natalia Paredes',NULL,'STUDENT'),('12A','1001234597','CE','Kevin Smith',NULL,'STUDENT'),('12B','1001234598','CE','Emily Johnson',NULL,'STUDENT'),('10A','1001234599','TI','Leonardo Medina',NULL,'STUDENT'),('10B','1001234600','CC','Fernanda Castillo',NULL,'STUDENT'),('11A','1001234601','TI','Gonzalo Navarro',NULL,'STUDENT'),('11B','1001234602','CC','Catalina Bravo',NULL,'STUDENT'),('9A','1001234603','RC','Rodrigo Salazar',NULL,'STUDENT'),('9B','1001234604','RC','Constanza Tapia',NULL,'STUDENT'),('12A','1001234605','CC','Patrick Wilson',NULL,'STUDENT'),('12B','1001234606','CE','Sophia Brown',NULL,'STUDENT'),('10A','1001234607','TI','Alexis Cordero',NULL,'STUDENT'),('10B','1001234608','CC','Javiera Sepúlveda',NULL,'STUDENT'),('11A','1001234609','TI','Maximiliano Guzmán',NULL,'STUDENT'),('11B','1001234610','CC','Florencia Ríos',NULL,'STUDENT'),('9A','1001234611','RC','Benjamín Espinoza',NULL,'STUDENT'),('9B','1001234612','RC','Martina Contreras',NULL,'STUDENT'),('12A','1001234613','PAS','Robert Davis',NULL,'STUDENT'),('12B','1001234614','PAS','Olivia Miller',NULL,'STUDENT'),('10A','1001234615','TI','Álvaro Fuentes',NULL,'STUDENT'),('10B','1001234616','CC','Bárbara Molina',NULL,'STUDENT'),('11A','1101234567','CC','Andrés Felipe Castillo',NULL,'STUDENT'),('11B','1101234568','CC','Gabriela Morales',NULL,'STUDENT'),('12A','1101234569','CC','David Alejandro Ruiz',NULL,'STUDENT'),('12B','1101234570','CC','Carolina Soto',NULL,'STUDENT'),('10A','1101234571','CC','Óscar Cordero',NULL,'STUDENT'),('10B','1101234572','CC','Rosa Elena Bravo',NULL,'STUDENT'),('11A','1101234573','CC','Mauricio Sepúlveda',NULL,'STUDENT'),('11B','1101234574','CC','Julia Tapia',NULL,'STUDENT'),('12A','1101234575','CC','Walter Rueda',NULL,'STUDENT'),('12B','1101234576','CC','Natalia Espinoza',NULL,'STUDENT'),('10A','1101234577','CC','Alberto Montoya',NULL,'STUDENT'),('10B','1101234578','CC','Sara Restrepo',NULL,'STUDENT'),('11A','1101234579','CC','Fabián Giraldo',NULL,'STUDENT'),('11B','1101234580','CC','Monica Londoño',NULL,'STUDENT'),('12A','1101234581','CC','Harold Suárez',NULL,'STUDENT'),('12B','1101234582','CC','Angela María Arias',NULL,'STUDENT'),('10A','1101234583','CC','Justin Robinson',NULL,'STUDENT'),('10B','1101234584','CC','Brittany Clark',NULL,'STUDENT'),('11A','1101234585','CC','Alexander Rodríguez',NULL,'STUDENT'),('11B','1101234586','CC','Victoria Lewis',NULL,'STUDENT'),('12A','1101234587','CC','Patrick Lee',NULL,'STUDENT'),('12B','1101234588','CC','Jennifer Walker',NULL,'STUDENT'),('10A','1101234589','CC','Ramon Turner',NULL,'STUDENT'),('10B','1101234590','CC','Irene Phillips',NULL,'STUDENT'),('11A','1101234591','CC','Enrique Campbell',NULL,'STUDENT'),('11B','1101234592','CC','Consuelo Parker',NULL,'STUDENT'),('12A','1101234593','CC','Sergio Evans',NULL,'STUDENT'),('12B','1101234594','CC','Aurora Edwards',NULL,'STUDENT'),('11A','1107974062','CC','Juan David Ospina Delgadillo ACTUALIZADO','6A','STUDENT'),('5B','1110466965','TI','Michael Giovanny de los Santos','6A','STUDENT'),('1C','2001234561','RC','Ignacio Rojas Pérez',NULL,'STUDENT'),('1D','2001234562','RC','Emilia Sánchez López',NULL,'STUDENT'),('2C','2001234563','RC','Bruno Díaz Castro',NULL,'STUDENT'),('2D','2001234564','RC','Catalina Ramírez Ortiz',NULL,'STUDENT'),('3C','2001234565','RC','Luca Fernández García',NULL,'STUDENT'),('3D','2001234566','RC','Zoe Martínez Rodríguez',NULL,'STUDENT'),('4C','2001234567','RC','Thiago González Silva',NULL,'STUDENT'),('4D','2001234568','RC','Aitana Morales Ruiz',NULL,'STUDENT'),('5C','2001234569','TI','Dylan Hernández Vega',NULL,'STUDENT'),('5D','2001234570','TI','Valentina Peña Cruz',NULL,'STUDENT'),('6C','2001234571','TI','Axel Díaz Ortega',NULL,'STUDENT'),('6D','2001234572','TI','Luna Mendoza Reyes',NULL,'STUDENT'),('7C','2001234573','TI','Ian Gutiérrez Delgado',NULL,'STUDENT'),('7D','2001234574','TI','Mía Núñez Herrera',NULL,'STUDENT'),('8C','2001234575','TI','Eithan Jiménez Castro',NULL,'STUDENT'),('8D','2001234576','TI','Abril Paredes Navarro',NULL,'STUDENT'),('9C','2001234577','CC','Sebastián Ríos Fuentes',NULL,'STUDENT'),('9D','2001234578','CC','Renata Salazar Bravo',NULL,'STUDENT'),('10C','2001234579','CC','Diego Espinoza Cordero',NULL,'STUDENT'),('10D','2001234580','CC','Antonella Tapia Ávila',NULL,'STUDENT'),('11C','2001234581','CC','Samuel Molina Romero',NULL,'STUDENT'),('11D','2001234582','CC','Julieta Aguilar Guzmán',NULL,'STUDENT'),('12C','2001234583','CC','Gabriel Sepúlveda Flores',NULL,'STUDENT'),('12D','2001234584','CC','Sofía Miranda Torres',NULL,'STUDENT'),('1A','3001234501','RC','Amir Khan',NULL,'STUDENT'),('1B','3001234502','RC','Lila Chen',NULL,'STUDENT'),('2A','3001234503','RC','Dante Rossi',NULL,'STUDENT'),('2B','3001234504','RC','Anika Schmidt',NULL,'STUDENT'),('3A','3001234505','RC','Kaito Tanaka',NULL,'STUDENT'),('3B','3001234506','RC','Maya Dubois',NULL,'STUDENT'),('4A','3001234507','RC','Rohan Patel',NULL,'STUDENT'),('4B','3001234508','RC','Chiara Ferrari',NULL,'STUDENT'),('5A','3001234509','TI','Oliver Johansson',NULL,'STUDENT'),('5B','3001234510','TI','Yara Ivanova',NULL,'STUDENT'),('6A','3001234511','TI','Elias Novak',NULL,'STUDENT'),('6B','3001234512','TI','Noor Al-Farsi',NULL,'STUDENT'),('7A','3001234513','TI','Leandro Costa',NULL,'STUDENT'),('7B','3001234514','TI','Freya Andersen',NULL,'STUDENT'),('8A','3001234515','TI','Mateusz Kowalski',NULL,'STUDENT'),('8B','3001234516','TI','Isabella Santos',NULL,'STUDENT'),('9A','4001234501','PAS','Lucas Martínez (silla de ruedas)',NULL,'STUDENT'),('10B','4001234502','PAS','Martina Rodríguez (hipoacusia)',NULL,'STUDENT'),('11A','4001234503','PAS','Facundo López (visión reducida)',NULL,'STUDENT'),('12B','4001234504','PAS','Florencia García (TEA)',NULL,'STUDENT'),('10A','5001234501','CE','William Smith (USA)',NULL,'STUDENT'),('10B','5001234502','CE','Sophie Martin (France)',NULL,'STUDENT'),('11A','5001234503','CE','Liam Johnson (Canada)',NULL,'STUDENT'),('11B','5001234504','CE','Emma Wilson (Australia)',NULL,'STUDENT'),('12A','5001234505','CE','Noah Brown (UK)',NULL,'STUDENT'),('12B','5001234506','CE','Olivia Taylor (New Zealand)',NULL,'STUDENT'),('6C','6001234501','TI','Juan Carlos Pérez Rodríguez',NULL,'STUDENT'),('7D','6001234502','TI','María José González López',NULL,'STUDENT'),('8C','6001234503','TI','José Antonio Martínez Sánchez',NULL,'STUDENT'),('9D','6001234504','CC','Ana María Fernández García',NULL,'STUDENT'),('10C','6001234505','CC','Luis Miguel Díaz Castro',NULL,'STUDENT'),('11D','6001234506','CC','Laura Patricia Ramírez Ortiz',NULL,'STUDENT'),('1A','7001234501','RC','Benjamín Herrera',NULL,'STUDENT'),('1B','7001234502','RC','Alma Rodríguez',NULL,'STUDENT'),('2A','7001234503','RC','Maximiliano Castro',NULL,'STUDENT'),('2B','7001234504','RC','Delfina Navarro',NULL,'STUDENT'),('3A','7001234505','RC','Joaquín Salazar',NULL,'STUDENT'),('3B','7001234506','RC','Agustina Fuentes',NULL,'STUDENT'),('4A','7001234507','RC','Tadeo Bravo',NULL,'STUDENT'),('4B','7001234508','RC','Celeste Espinoza',NULL,'STUDENT'),('5A','7001234509','TI','Bautista Cordero',NULL,'STUDENT'),('5B','7001234510','TI','Jazmín Tapia',NULL,'STUDENT'),('6A','7001234511','TI','Santino Ávila',NULL,'STUDENT'),('6B','7001234512','TI','Bianca Molina',NULL,'STUDENT'),('7A','7001234513','TI','Lorenzo Romero',NULL,'STUDENT'),('7B','7001234514','TI','Morena Aguilar',NULL,'STUDENT'),('8A','7001234515','TI','Tiziano Guzmán',NULL,'STUDENT'),('8B','7001234516','TI','Luciana Sepúlveda',NULL,'STUDENT'),('9A','7001234517','CC','Salvatore Flores',NULL,'STUDENT'),('9B','7001234518','CC','Giuliana Miranda',NULL,'STUDENT'),('10A','7001234519','CC','Damián Torres',NULL,'STUDENT'),('10B','7001234520','CC','Alondra Vargas',NULL,'STUDENT'),('11A','7001234521','CC','Marcelo Contreras',NULL,'STUDENT'),('11B','7001234522','CC','Catalina Soto',NULL,'STUDENT'),('12A','7001234523','CC','Rafael Muñoz',NULL,'STUDENT'),('12B','7001234524','CC','Victoria Pérez',NULL,'STUDENT'),('4C','8001234501','RC','Wayra Mamani',NULL,'STUDENT'),('5C','8001234502','TI','Inti Quispe',NULL,'STUDENT'),('6C','8001234503','TI','Killa Chávez',NULL,'STUDENT'),('7C','8001234504','TI','Yaku Condori',NULL,'STUDENT'),('8C','8001234505','TI','Pacha Huanca',NULL,'STUDENT'),('9C','8001234506','CC','Sami Yupanqui',NULL,'STUDENT'),('1C','9001234501','RC','Francisco Javier',NULL,'STUDENT'),('2C','9001234502','RC','María de los Ángeles',NULL,'STUDENT'),('3C','9001234503','RC','José María',NULL,'STUDENT'),('4D','9001234504','RC','Ana Teresa',NULL,'STUDENT'),('5D','9001234505','TI','Juan Pablo',NULL,'STUDENT'),('6D','9001234506','TI','Rosa Elena',NULL,'STUDENT'),('7D','9001234507','TI','Miguel Ángel',NULL,'STUDENT'),('8D','9001234508','TI','Carmen Cecilia',NULL,'STUDENT'),('9D','9001234509','CC','Pedro Antonio',NULL,'STUDENT'),('10D','9001234510','CC','Luisa Fernanda',NULL,'STUDENT'),('11D','9001234511','CC','Alberto José',NULL,'STUDENT'),('12D','9001234512','CC','Elena María',NULL,'STUDENT'),('1D','9101234501','RC','Nicolás Alejandro',NULL,'STUDENT'),('2D','9101234502','RC','Gabriela Isabel',NULL,'STUDENT'),('3D','9101234503','RC','Ricardo Andrés',NULL,'STUDENT'),('4C','9101234504','RC','Patricia Carolina',NULL,'STUDENT'),('5C','9101234505','TI','Federico Manuel',NULL,'STUDENT'),('6C','9101234506','TI','Verónica Andrea',NULL,'STUDENT'),('7C','9101234507','TI','Guillermo Esteban',NULL,'STUDENT'),('8C','9101234508','TI','Claudia Marcela',NULL,'STUDENT'),('9C','9101234509','CC','Humberto Rafael',NULL,'STUDENT'),('10C','9101234510','CC','Adriana Lucía',NULL,'STUDENT'),('11C','9101234511','CC','Mauricio David',NULL,'STUDENT'),('12C','9101234512','CC','Ximena Patricia',NULL,'STUDENT'),('1A','9201234501','RC','Cristóbal Ignacio',NULL,'STUDENT'),('2A','9201234502','RC','Pamela Alejandra',NULL,'STUDENT'),('3A','9201234503','RC','Rodrigo Felipe',NULL,'STUDENT'),('4A','9201234504','RC','Carolina Daniela',NULL,'STUDENT'),('5A','9201234505','TI','Fabián Leonardo',NULL,'STUDENT'),('6A','9201234506','TI','Paulina Victoria',NULL,'STUDENT'),('7A','9201234507','TI','Cristian Omar',NULL,'STUDENT'),('8A','9201234508','TI','Javiera Francisca',NULL,'STUDENT'),('9A','9201234509','CC','Héctor Alejandro',NULL,'STUDENT'),('10A','9201234510','CC','Macarena Antonia',NULL,'STUDENT'),('11A','9201234511','CC','Víctor Manuel',NULL,'STUDENT'),('12A','9201234512','CC','Francisca Ignacia',NULL,'STUDENT'),('1B','9301234501','RC','Esteban Nicolás',NULL,'STUDENT'),('2B','9301234502','RC','Daniela Paz',NULL,'STUDENT'),('3B','9301234503','RC','Alejandro Javier',NULL,'STUDENT'),('4B','9301234504','RC','Katherine Nicole',NULL,'STUDENT'),('5B','9301234505','TI','Pablo Andrés',NULL,'STUDENT'),('6B','9301234506','TI','María Soledad',NULL,'STUDENT'),('7B','9301234507','TI','Luis Fernando',NULL,'STUDENT'),('8B','9301234508','TI','Camila Belén',NULL,'STUDENT'),('9B','9301234509','CC','Gustavo Adolfo',NULL,'STUDENT'),('10B','9301234510','CC','Constanza Andrea',NULL,'STUDENT'),('11B','9301234511','CC','Nelson Eduardo',NULL,'STUDENT'),('12B','9301234512','CC','Bárbara Alejandra',NULL,'STUDENT'),('11B','987654321','TI','María García',NULL,'STUDENT');
/*!40000 ALTER TABLE `students_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teachers_tbl`
--

DROP TABLE IF EXISTS `teachers_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teachers_tbl` (
  `teacher_email` varchar(255) DEFAULT NULL,
  `teacher_identification_number` varchar(255) NOT NULL,
  `teacher_identification_type` varchar(255) DEFAULT NULL,
  `teacher_name` varchar(255) DEFAULT NULL,
  `teacher_phone` varchar(255) DEFAULT NULL,
  `teacher_subject` varchar(255) DEFAULT NULL,
  `role` enum('DIRECTOR','STUDENT','TEACHER') DEFAULT NULL,
  `director_identification_number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`teacher_identification_number`),
  UNIQUE KEY `uk_teacher_identification` (`teacher_identification_number`),
  KEY `FKqu443emup4kcjtsieeqdjj8qy` (`director_identification_number`),
  CONSTRAINT `FKqu443emup4kcjtsieeqdjj8qy` FOREIGN KEY (`director_identification_number`) REFERENCES `directors_tbl` (`director_identification_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teachers_tbl`
--

LOCK TABLES `teachers_tbl` WRITE;
/*!40000 ALTER TABLE `teachers_tbl` DISABLE KEYS */;
INSERT INTO `teachers_tbl` VALUES ('rufo.ramirez@colegio.com','988790243','CC','Rufo de dios Ramirez','3001234511','Filosofia','TEACHER',NULL);
/*!40000 ALTER TABLE `teachers_tbl` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-02-01 14:37:16
