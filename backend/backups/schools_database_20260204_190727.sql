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
  CONSTRAINT `FK4rar4a3mldeviwp70buowvjfx` FOREIGN KEY (`student_identification_number`) REFERENCES `students_tbl` (`student_identification_number`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books_tbl`
--

LOCK TABLES `books_tbl` WRITE;
/*!40000 ALTER TABLE `books_tbl` DISABLE KEYS */;
INSERT INTO `books_tbl` VALUES (1,'Gabriel García Márquez','Ficción','Cien años de soledad',NULL),(3,'Jorge Luis Borges','Ficción','Ficciones',NULL),(4,'Julio Cortázar','Ficción','Rayuela',NULL),(5,'Isabel Allende','Ficción','La casa de los espíritus','65762617'),(6,'J.R.R. Tolkien','Fantasía','El Señor de los Anillos',NULL),(7,'J.K. Rowling','Fantasía','Harry Potter y la piedra filosofal',NULL),(8,'George R.R. Martin','Fantasía','Juego de Tronos',NULL),(9,'Patrick Rothfuss','Fantasía','El nombre del viento',NULL),(10,'Brandon Sanderson','Fantasía','El camino de los reyes',NULL),(11,'Isaac Asimov','Ciencia Ficción','Fundación',NULL),(12,'Frank Herbert','Ciencia Ficción','Dune',NULL),(13,'Philip K. Dick','Ciencia Ficción','¿Sueñan los androides con ovejas eléctricas?',NULL),(14,'Arthur C. Clarke','Ciencia Ficción','2001: Una odisea espacial',NULL),(15,'Ray Bradbury','Ciencia Ficción','Fahrenheit 451',NULL),(16,'Agatha Christie','Misterio','Asesinato en el Orient Express',NULL),(17,'Dan Brown','Thriller','El código Da Vinci',NULL),(18,'Stieg Larsson','Thriller','Los hombres que no amaban a las mujeres',NULL),(19,'Gillian Flynn','Thriller','Perdida',NULL),(20,'Arthur Conan Doyle','Misterio','El sabueso de los Baskerville',NULL),(21,'Jane Austen','Romance','Orgullo y prejuicio',NULL),(22,'Nicholas Sparks','Romance','El diario de Noah',NULL),(23,'Emily Brontë','Romance','Cumbres borrascosas',NULL),(24,'John Green','Romance','Bajo la misma estrella',NULL),(25,'Jojo Moyes','Romance','Yo antes de ti',NULL),(26,'Stephen Hawking','Ciencia','Breve historia del tiempo',NULL),(27,'Yuval Noah Harari','Historia','Sapiens: De animales a dioses',NULL),(28,'Dale Carnegie','Autoayuda','Cómo ganar amigos e influir sobre las personas',NULL),(29,'Viktor Frankl','Psicología','El hombre en busca de sentido',NULL),(30,'James Clear','Autoayuda','Hábitos atómicos',NULL),(31,'Walter Isaacson','Biografía','Steve Jobs',NULL),(32,'Anne Frank','Memorias','El diario de Ana Frank',NULL),(33,'Malala Yousafzai','Biografía','Yo soy Malala',NULL),(34,'Michelle Obama','Memorias','Mi historia',NULL),(35,'Nelson Mandela','Autobiografía','El largo camino hacia la libertad',NULL),(36,'Stephen King','Terror','It (Eso)',NULL),(37,'Edgar Allan Poe','Terror','Cuentos de terror',NULL),(38,'H.P. Lovecraft','Terror','La llamada de Cthulhu',NULL),(39,'Bram Stoker','Terror','Drácula',NULL),(40,'Mary Shelley','Terror','Frankenstein',NULL),(41,'Friedrich Nietzsche','Filosofía','Así habló Zaratustra',NULL),(42,'Platón','Filosofía','La República',NULL),(43,'René Descartes','Filosofía','Discurso del método',NULL),(44,'Séneca','Filosofía','Cartas a Lucilio',NULL),(45,'Marcus Aurelius','Filosofía','Meditaciones',NULL),(46,'Suzanne Collins','Distopía','Los juegos del hambre',NULL),(47,'Veronica Roth','Distopía','Divergente',NULL),(48,'George Orwell','Distopía','1984',NULL),(49,'Aldous Huxley','Distopía','Un mundo feliz',NULL),(51,'Miguel de Cervantes','Ficción','Don Quijote de la Mancha',NULL),(53,'Gustavo Petro','Romance','A traves de mi ventana',NULL);
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
INSERT INTO `directors_tbl` VALUES ('1107974062','juan.ospina@empresa.com','CC','Juan David Ospina Delgadillo','$2a$10$Cy3IwQfeXH206/./KxLidOVakLvWgEOIPaXLbmopcTaYotfToQkVa','jdaospinad','DIRECTOR'),('65762617','william.ospina@colegio.com','CC','William Ospina','$2a$10$Z3aX9oxT4aCvExyUnAVEauNQnX9bG4Up9ZGb.oHJJ2IAFn0SlkdT.','wiospina','DIRECTOR');
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
INSERT INTO `grade_groups_tbl` VALUES ('10A','Sede Calle 144 - 5 Calle linares - Bucaramanga',5,'10','A','MORNING',NULL),('10B','Sede Calle 144 - 5 Calle linares - Bucaramanga',5,'10','B','AFTERNOON',NULL),('11A','Sede Calle 144 - 5 Calle linares - Bucaramanga',5,'11','A','MORNING',NULL),('1A','Sede Calle 144 - 5 Calle linares - Bucaramanga',4,'1','A','MORNING',NULL),('1B','Sede Calle 144 - 5 Calle linares - Bucaramanga',4,'1','B','AFTERNOON',NULL),('1C','Sede Calle 144 - 5 Calle linares - Bucaramanga',4,'1','C','NIGHT',NULL),('2A','Sede Calle 144 - 5 Calle linares - Bucaramanga',4,'2','A','MORNING',NULL),('2B','Sede Calle 144 - 5 Calle linares - Bucaramanga',4,'2','B','AFTERNOON',NULL),('2C','Sede Calle 144 - 5 Calle linares - Bucaramanga',4,'2','C','NIGHT',NULL),('3A','Sede Calle 144 - 5 Calle linares - Bucaramanga',4,'3','A','MORNING',NULL),('3B','Sede Calle 144 - 5 Calle linares - Bucaramanga',4,'3','B','AFTERNOON',NULL),('3C','Sede Calle 144 - 5 Calle linares - Bucaramanga',4,'3','C','NIGHT',NULL),('4A','Sede Calle 144 - 5 Calle linares - Bucaramanga',1,'4','A','MORNING',NULL),('4B','Sede Calle 144 - 5 Calle linares - Bucaramanga',1,'4','B','AFTERNOON',NULL),('4C','Sede Calle 144 - 5 Calle linares - Bucaramanga',1,'4','C','NIGHT',NULL),('5A','Sede Calle 144 - 5 Calle linares - Bucaramanga',1,'5','A','MORNING',NULL),('5B','Sede Calle 144 - 5 Calle linares - Bucaramanga',1,'5','B','AFTERNOON',NULL),('5C','Sede Calle 144 - 5 Calle linares - Bucaramanga',1,'5','C','NIGHT',NULL),('6A','Sede Calle 144 - 5 Calle linares - Bucaramanga',2,'6','A','MORNING',NULL),('6B','Sede Calle 144 - 5 Calle linares - Bucaramanga',2,'6','B','AFTERNOON',NULL),('6C','Sede Calle 144 - 5 Calle linares - Bucaramanga',2,'6','C','NIGHT',NULL),('6D','Sede Calle 144 - 5 Calle linares - Bucaramanga',2,'6','D','SATURDAY',NULL),('7A','Sede Calle 144 - 5 Calle linares - Bucaramanga',2,'7','A','MORNING',NULL),('7B','Sede Calle 144 - 5 Calle linares - Bucaramanga',2,'7','B','AFTERNOON',NULL),('8A','Sede Calle 144 - 5 Calle linares - Bucaramanga',3,'8','A','MORNING',NULL),('8B','Sede Calle 144 - 5 Calle linares - Bucaramanga',3,'8','B','AFTERNOON',NULL),('8C','Sede Calle 144 - 5 Calle linares - Bucaramanga',3,'8','C','NIGHT',NULL),('8D','Sede Calle 144 - 5 Calle linares - Bucaramanga',1,'8','D','SATURDAY',NULL),('9A','Sede Calle 144 - 5 Calle linares - Bucaramanga',3,'9','A','MORNING',NULL),('9B','Sede Calle 144 - 5 Calle linares - Bucaramanga',3,'9','B','AFTERNOON',NULL);
/*!40000 ALTER TABLE `grade_groups_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students_tbl`
--

DROP TABLE IF EXISTS `students_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `students_tbl` (
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
INSERT INTO `students_tbl` VALUES ('1000012345','RC','Valentina Rodríguez','6B','STUDENT'),('1000012346','RC','Santiago Gómez','6A','STUDENT'),('1000012347','RC','Isabella Martínez','6A','STUDENT'),('1000012348','RC','Mateo López','6A','STUDENT'),('1000012349','RC','Sofía Hernández','6A','STUDENT'),('1000012350','RC','Diego García','6A','STUDENT'),('1000012351','RC','Camila Pérez','6A','STUDENT'),('1000012352','RC','Nicolás Fernández','6A','STUDENT'),('1000012353','RC','Mariana Díaz','6A','STUDENT'),('1000012354','RC','Julián Sánchez','6A','STUDENT'),('1000012355','TI','Lucía Ramírez','6A','STUDENT'),('1000012356','TI','Daniel Castro','6A','STUDENT'),('1000012357','TI','Ximena Torres','6A','STUDENT'),('1000012358','TI','Samuel Ortiz','6A','STUDENT'),('1000012359','TI','Valeria Silva','6A','STUDENT'),('1000012360','TI','Miguel Mendoza','6A','STUDENT'),('1000012361','TI','Ana Vargas','6A','STUDENT'),('1000012362','TI','Juan Camilo Rojas','6A','STUDENT'),('1000012363','CC','Carlos Andrés Herrera','6A','STUDENT'),('1000012364','CC','Laura González','6A','STUDENT'),('1000012365','RC','Alejandro Jiménez','6A','STUDENT'),('1000012366','RC','Paula Ávila','6A','STUDENT'),('1000012367','RC','Felipe Castro','6A','STUDENT'),('1000012368','RC','Daniela Ríos','6A','STUDENT'),('1000012369','RC','Jorge Luis Muñoz','6A','STUDENT'),('1000012370','RC','Adriana Núñez','6A','STUDENT'),('1000012371','RC','Ricardo Peña','1A','STUDENT'),('1000012372','RC','Fernanda Delgado','1A','STUDENT'),('1000012373','RC','Héctor Guzmán','1A','STUDENT'),('1000012374','RC','Elena Romero','1A','STUDENT'),('1000012375','TI','Raúl Ortega','1A','STUDENT'),('1000012376','TI','Patricia Marín','1A','STUDENT'),('1000012377','TI','Roberto Salazar','1A','STUDENT'),('1000012378','TI','Tatiana Vega','1A','STUDENT'),('1000012379','TI','Cristian Flores','1A','STUDENT'),('1000012380','TI','Claudia Medina','1A','STUDENT'),('1000012381','TI','Gustavo Navarro','1A','STUDENT'),('1000012382','TI','Diana Paredes','1A','STUDENT'),('1000012383','RC','Luis Fernando Acosta','1A','STUDENT'),('1000012384','RC','Verónica Carrillo','1A','STUDENT'),('1000012385','RC','Edison Franco','1A','STUDENT'),('1000012386','RC','Liliana Ponce','1A','STUDENT'),('1000012387','RC','Hugo Vera','1A','STUDENT'),('1000012388','RC','Silvia Zambrano','1A','STUDENT'),('1000012389','RC','Rafael Aguirre','1A','STUDENT'),('1000012390','RC','Alicia Cáceres','1A','STUDENT'),('1000012391','RC','Esteban Molina','1A','STUDENT'),('1000012392','RC','Yolanda León','1A','STUDENT'),('1000012393','TI','Fabian Quintero','1A','STUDENT'),('1000012394','TI','Beatriz Valencia','1A','STUDENT'),('1000012395','TI','Milton Parra','1A','STUDENT'),('1000012396','TI','Rocío Méndez','1A','STUDENT'),('1000012397','TI','Wilson Cárdenas','1A','STUDENT'),('1000012398','TI','Olga Lozano','1A','STUDENT'),('1000012399','TI','Pablo Escobar','1A','STUDENT'),('1000012400','TI','Carmen Rosa Fuentes','1A','STUDENT'),('1000012401','RC','Johan Smith','1B','STUDENT'),('1000012402','RC','Danna Johnson','1B','STUDENT'),('1000012403','RC','Steven Williams','1B','STUDENT'),('1000012404','RC','Melissa Brown','1B','STUDENT'),('1000012405','RC','Brian Jones','1B','STUDENT'),('1000012406','RC','Vanessa Davis','1B','STUDENT'),('1000012407','RC','Jason Miller','1B','STUDENT'),('1000012408','RC','Stephanie Wilson','1B','STUDENT'),('1000012409','RC','Kevin Taylor','1B','STUDENT'),('1000012410','RC','Nicole Anderson','1B','STUDENT'),('1000012411','TI','Brandon Thomas','1B','STUDENT'),('1000012412','TI','Christina Jackson','1B','STUDENT'),('1000012413','TI','Gary White','1B','STUDENT'),('1000012414','TI','Rachel Harris','1B','STUDENT'),('1000012415','TI','Eric Martin','1B','STUDENT'),('1000012416','TI','Amanda Thompson','1B','STUDENT'),('1000012417','TI','Scott Garcia','1B','STUDENT'),('1000012418','TI','Tiffany Martinez','1B','STUDENT'),('1000012419','RC','Eduardo Hall','1B','STUDENT'),('1000012420','RC','Gabriela Allen','1B','STUDENT'),('1000012421','RC','José Young','1B','STUDENT'),('1000012422','RC','Paulina King','1B','STUDENT'),('1000012423','RC','Manuel Wright','1B','STUDENT'),('1000012424','RC','Elena Scott','1B','STUDENT'),('1000012425','RC','Pedro Torres','1B','STUDENT'),('1000012426','RC','Rosa Nguyen','10A','STUDENT'),('1000012427','RC','Francisco Hill','10A','STUDENT'),('1000012428','RC','Luisa Flores','10A','STUDENT'),('1000012429','TI','Javier Green','10A','STUDENT'),('1000012430','TI','Marta Adams','10A','STUDENT'),('1000012431','TI','Raul Nelson','10A','STUDENT'),('1000012432','TI','Teresa Baker','10A','STUDENT'),('1000012433','TI','Alfonso Carter','10A','STUDENT'),('1000012434','TI','Ruth Mitchell','10A','STUDENT'),('1000012435','TI','Antonio Pérez','10A','STUDENT'),('1000012436','TI','Eva Roberts','10A','STUDENT'),('1001234567','CC','Juan Camilo Pérez','10A','STUDENT'),('1001234568','CC','María Fernanda González','11A','STUDENT'),('1001234569','TI','Carlos Andrés Rodríguez','11A','STUDENT'),('1001234570','TI','Ana Sofía Martínez','11A','STUDENT'),('1001234571','RC','Sebastián López','11A','STUDENT'),('1001234572','RC','Valentina Sánchez','11A','STUDENT'),('1001234573','CC','Andrés Felipe Ramírez','11A','STUDENT'),('1001234574','CC','Isabella Torres','11A','STUDENT'),('1001234575','TI','Mateo Herrera','11A','STUDENT'),('1001234576','CC','Sofía Castro','11A','STUDENT'),('1001234577','TI','Samuel Díaz','11A','STUDENT'),('1001234578','CC','Mariana Ortega','11A','STUDENT'),('1001234579','RC','Daniel Gómez','11A','STUDENT'),('1001234580','RC','Gabriela Mendoza','11A','STUDENT'),('1001234581','CC','David Jiménez','11A','STUDENT'),('1001234582','CC','Camila Ruiz','11A','STUDENT'),('1001234583','TI','Julián Silva','11A','STUDENT'),('1001234584','CC','Lucía Vargas','11A','STUDENT'),('1001234585','TI','Tomás Rojas','11A','STUDENT'),('1001234586','CC','Antonella Flores','11A','STUDENT'),('1001234587','RC','Emilio Reyes','11A','STUDENT'),('1001234588','RC','Victoria Núñez','11A','STUDENT'),('1001234589','CC','Felipe Peña','11A','STUDENT'),('1001234590','CC','Ximena Delgado','11A','STUDENT'),('1001234591','TI','Ricardo Morales','10B','STUDENT'),('1001234592','CC','Daniela Suárez','10B','STUDENT'),('1001234593','TI','Alejandro Vega','11A','STUDENT'),('1001234594','CC','Paola Romero','10B','STUDENT'),('1001234595','RC','Hugo Aguilar','1C','STUDENT'),('1001234596','RC','Natalia Paredes','10B','STUDENT'),('1001234597','CE','Kevin Smith','10B','STUDENT'),('1001234598','CE','Emily Johnson','10B','STUDENT'),('1001234599','TI','Leonardo Medina','10B','STUDENT'),('1001234600','CC','Fernanda Castillo','10B','STUDENT'),('1001234601','TI','Gonzalo Navarro','10B','STUDENT'),('1001234602','CC','Catalina Bravo','10B','STUDENT'),('1001234603','RC','Rodrigo Salazar','10B','STUDENT'),('1001234604','RC','Constanza Tapia','10B','STUDENT'),('1001234605','CC','Patrick Wilson','10B','STUDENT'),('1001234606','CE','Sophia Brown','10B','STUDENT'),('1001234607','TI','Alexis Cordero','10B','STUDENT'),('1001234608','CC','Javiera Sepúlveda','10B','STUDENT'),('1001234609','TI','Maximiliano Guzmán','11A','STUDENT'),('1001234610','CC','Florencia Ríos','11A','STUDENT'),('1001234611','RC','Benjamín Espinoza','11A','STUDENT'),('1001234612','RC','Martina Contreras','1C','STUDENT'),('1001234613','PAS','Robert Davis','1C','STUDENT'),('1001234614','PAS','Olivia Miller','11A','STUDENT'),('1001234615','TI','Álvaro Fuentes','11A','STUDENT'),('1001234616','CC','Bárbara Molina','11A','STUDENT'),('1101234567','CC','Andrés Felipe Castillo','11A','STUDENT'),('1101234568','CC','Gabriela Morales','1C','STUDENT'),('1101234569','CC','David Alejandro Ruiz','1C','STUDENT'),('1101234570','CC','Carolina Soto','1C','STUDENT'),('1101234571','CC','Óscar Cordero','1C','STUDENT'),('1101234572','CC','Rosa Elena Bravo','1C','STUDENT'),('1101234573','CC','Mauricio Sepúlveda','1C','STUDENT'),('1101234574','CC','Julia Tapia','1C','STUDENT'),('1101234575','CC','Walter Rueda','1C','STUDENT'),('1101234576','CC','Natalia Espinoza','1C','STUDENT'),('1101234577','CC','Alberto Montoya','1C','STUDENT'),('1101234578','CC','Sara Restrepo','1C','STUDENT'),('1101234579','CC','Fabián Giraldo','1C','STUDENT'),('1101234580','CC','Monica Londoño','1C','STUDENT'),('1101234581','CC','Harold Suárez','1C','STUDENT'),('1101234582','CC','Angela María Arias','1C','STUDENT'),('1101234583','CC','Justin Robinson','1C','STUDENT'),('1101234584','CC','Brittany Clark','1C','STUDENT'),('1101234585','CC','Alexander Rodríguez','1C','STUDENT'),('1101234586','CC','Victoria Lewis','1C','STUDENT'),('1101234587','CC','Patrick Lee','1C','STUDENT'),('1101234588','CC','Jennifer Walker','1C','STUDENT'),('1101234589','CC','Ramon Turner','1C','STUDENT'),('1101234590','CC','Irene Phillips','1C','STUDENT'),('1101234591','CC','Enrique Campbell','1C','STUDENT'),('1101234592','CC','Consuelo Parker','1C','STUDENT'),('1101234593','CC','Sergio Evans','1C','STUDENT'),('1101234594','CC','Aurora Edwards','1C','STUDENT'),('1110466965','TI','Michael Giovanny de los Santos','6A','STUDENT'),('2001234561','RC','Ignacio Rojas Pérez','2A','STUDENT'),('2001234562','RC','Emilia Sánchez López','2A','STUDENT'),('2001234563','RC','Bruno Díaz Castro','2A','STUDENT'),('2001234564','RC','Catalina Ramírez Ortiz','2A','STUDENT'),('2001234565','RC','Luca Fernández García','2A','STUDENT'),('2001234566','RC','Zoe Martínez Rodríguez','2A','STUDENT'),('2001234567','RC','Thiago González Silva','2A','STUDENT'),('2001234568','RC','Aitana Morales Ruiz','2A','STUDENT'),('2001234569','TI','Dylan Hernández Vega','2A','STUDENT'),('2001234570','TI','Valentina Peña Cruz','2A','STUDENT'),('2001234571','TI','Axel Díaz Ortega','2A','STUDENT'),('2001234572','TI','Luna Mendoza Reyes','2A','STUDENT'),('2001234573','TI','Ian Gutiérrez Delgado','2A','STUDENT'),('2001234574','TI','Mía Núñez Herrera','2A','STUDENT'),('2001234575','TI','Eithan Jiménez Castro','2A','STUDENT'),('2001234576','TI','Abril Paredes Navarro','2A','STUDENT'),('2001234577','CC','Sebastián Ríos Fuentes','2A','STUDENT'),('2001234578','CC','Renata Salazar Bravo','2A','STUDENT'),('2001234579','CC','Diego Espinoza Cordero','2A','STUDENT'),('2001234580','CC','Antonella Tapia Ávila','2A','STUDENT'),('2001234581','CC','Samuel Molina Romero','2A','STUDENT'),('2001234582','CC','Julieta Aguilar Guzmán','2A','STUDENT'),('2001234583','CC','Gabriel Sepúlveda Flores','2A','STUDENT'),('2001234584','CC','Sofía Miranda Torres','2A','STUDENT'),('3001234501','RC','Amir Khan','2B','STUDENT'),('3001234502','RC','Lila Chen','2B','STUDENT'),('3001234503','RC','Dante Rossi','2B','STUDENT'),('3001234504','RC','Anika Schmidt','2B','STUDENT'),('3001234505','RC','Kaito Tanaka','2B','STUDENT'),('3001234506','RC','Maya Dubois','2B','STUDENT'),('3001234507','RC','Rohan Patel','2B','STUDENT'),('3001234508','RC','Chiara Ferrari','2B','STUDENT'),('3001234509','TI','Oliver Johansson','2B','STUDENT'),('3001234510','TI','Yara Ivanova','2B','STUDENT'),('3001234511','TI','Elias Novak','2B','STUDENT'),('3001234512','TI','Noor Al-Farsi','2B','STUDENT'),('3001234513','TI','Leandro Costa','2B','STUDENT'),('3001234514','TI','Freya Andersen','2B','STUDENT'),('3001234515','TI','Mateusz Kowalski','2B','STUDENT'),('3001234516','TI','Isabella Santos','2B','STUDENT'),('4001234501','PAS','Lucas Martínez (silla de ruedas)','2B','STUDENT'),('4001234502','PAS','Martina Rodríguez (hipoacusia)','2B','STUDENT'),('4001234503','PAS','Facundo López (visión reducida)','2B','STUDENT'),('4001234504','PAS','Florencia García (TEA)','2B','STUDENT'),('5001234501','CE','William Smith (USA)','2B','STUDENT'),('5001234502','CE','Sophie Martin (France)','2B','STUDENT'),('5001234503','CE','Liam Johnson (Canada)','2B','STUDENT'),('5001234504','CE','Emma Wilson (Australia)','2B','STUDENT'),('5001234505','CE','Noah Brown (UK)','2B','STUDENT'),('5001234506','CE','Olivia Taylor (New Zealand)',NULL,'STUDENT'),('6001234501','TI','Juan Carlos Pérez Rodríguez','2B','STUDENT'),('6001234502','TI','María José González López','2B','STUDENT'),('6001234503','TI','José Antonio Martínez Sánchez','2B','STUDENT'),('6001234504','CC','Ana María Fernández García','2B','STUDENT'),('6001234505','CC','Luis Miguel Díaz Castro','2B','STUDENT'),('6001234506','CC','Laura Patricia Ramírez Ortiz','2B','STUDENT'),('65762617','CC','Angelica Delgadillo Medina','6B','STUDENT'),('7001234501','RC','Benjamín Herrera','2B','STUDENT'),('7001234502','RC','Alma Rodríguez',NULL,'STUDENT'),('7001234503','RC','Maximiliano Castro',NULL,'STUDENT'),('7001234504','RC','Delfina Navarro',NULL,'STUDENT'),('7001234505','RC','Joaquín Salazar',NULL,'STUDENT'),('7001234506','RC','Agustina Fuentes',NULL,'STUDENT'),('7001234507','RC','Tadeo Bravo',NULL,'STUDENT'),('7001234508','RC','Celeste Espinoza',NULL,'STUDENT'),('7001234509','TI','Bautista Cordero',NULL,'STUDENT'),('7001234510','TI','Jazmín Tapia',NULL,'STUDENT'),('7001234511','TI','Santino Ávila',NULL,'STUDENT'),('7001234512','TI','Bianca Molina',NULL,'STUDENT'),('7001234513','TI','Lorenzo Romero',NULL,'STUDENT'),('7001234514','TI','Morena Aguilar',NULL,'STUDENT'),('7001234515','TI','Tiziano Guzmán',NULL,'STUDENT'),('7001234516','TI','Luciana Sepúlveda',NULL,'STUDENT'),('7001234517','CC','Salvatore Flores',NULL,'STUDENT'),('7001234518','CC','Giuliana Miranda',NULL,'STUDENT'),('7001234519','CC','Damián Torres',NULL,'STUDENT'),('7001234520','CC','Alondra Vargas',NULL,'STUDENT'),('7001234521','CC','Marcelo Contreras',NULL,'STUDENT'),('7001234522','CC','Catalina Soto',NULL,'STUDENT'),('7001234523','CC','Rafael Muñoz',NULL,'STUDENT'),('7001234524','CC','Victoria Pérez',NULL,'STUDENT'),('8001234501','RC','Wayra Mamani',NULL,'STUDENT'),('8001234502','TI','Inti Quispe',NULL,'STUDENT'),('8001234503','TI','Killa Chávez',NULL,'STUDENT'),('8001234504','TI','Yaku Condori',NULL,'STUDENT'),('8001234505','TI','Pacha Huanca',NULL,'STUDENT'),('8001234506','CC','Sami Yupanqui',NULL,'STUDENT'),('9001234501','RC','Francisco Javier',NULL,'STUDENT'),('9001234502','RC','María de los Ángeles',NULL,'STUDENT'),('9001234503','RC','José María',NULL,'STUDENT'),('9001234504','RC','Ana Teresa',NULL,'STUDENT'),('9001234505','TI','Juan Pablo',NULL,'STUDENT'),('9001234506','TI','Rosa Elena',NULL,'STUDENT'),('9001234507','TI','Miguel Ángel',NULL,'STUDENT'),('9001234508','TI','Carmen Cecilia',NULL,'STUDENT'),('9001234509','CC','Pedro Antonio',NULL,'STUDENT'),('9001234510','CC','Luisa Fernanda',NULL,'STUDENT'),('9001234511','CC','Alberto José',NULL,'STUDENT'),('9001234512','CC','Elena María',NULL,'STUDENT'),('9101234501','RC','Nicolás Alejandro',NULL,'STUDENT'),('9101234502','RC','Gabriela Isabel',NULL,'STUDENT'),('9101234503','RC','Ricardo Andrés',NULL,'STUDENT'),('9101234504','RC','Patricia Carolina',NULL,'STUDENT'),('9101234505','TI','Federico Manuel',NULL,'STUDENT'),('9101234506','TI','Verónica Andrea',NULL,'STUDENT'),('9101234507','TI','Guillermo Esteban',NULL,'STUDENT'),('9101234508','TI','Claudia Marcela',NULL,'STUDENT'),('9101234509','CC','Humberto Rafael',NULL,'STUDENT'),('9101234510','CC','Adriana Lucía',NULL,'STUDENT'),('9101234511','CC','Mauricio David',NULL,'STUDENT'),('9101234512','CC','Ximena Patricia',NULL,'STUDENT'),('9201234501','RC','Cristóbal Ignacio',NULL,'STUDENT'),('9201234502','RC','Pamela Alejandra',NULL,'STUDENT'),('9201234503','RC','Rodrigo Felipe',NULL,'STUDENT'),('9201234504','RC','Carolina Daniela',NULL,'STUDENT'),('9201234505','TI','Fabián Leonardo',NULL,'STUDENT'),('9201234506','TI','Paulina Victoria',NULL,'STUDENT'),('9201234507','TI','Cristian Omar',NULL,'STUDENT'),('9201234508','TI','Javiera Francisca',NULL,'STUDENT'),('9201234509','CC','Héctor Alejandro',NULL,'STUDENT'),('9201234510','CC','Macarena Antonia',NULL,'STUDENT'),('9201234511','CC','Víctor Manuel',NULL,'STUDENT'),('9201234512','CC','Francisca Ignacia',NULL,'STUDENT'),('9301234501','RC','Esteban Nicolás',NULL,'STUDENT'),('9301234502','RC','Daniela Paz',NULL,'STUDENT'),('9301234503','RC','Alejandro Javier',NULL,'STUDENT'),('9301234504','RC','Katherine Nicole',NULL,'STUDENT'),('9301234505','TI','Pablo Andrés',NULL,'STUDENT'),('9301234506','TI','María Soledad',NULL,'STUDENT'),('9301234507','TI','Luis Fernando',NULL,'STUDENT'),('9301234508','TI','Camila Belén',NULL,'STUDENT'),('9301234509','CC','Gustavo Adolfo',NULL,'STUDENT'),('9301234510','CC','Constanza Andrea',NULL,'STUDENT'),('9301234511','CC','Nelson Eduardo',NULL,'STUDENT'),('9301234512','CC','Bárbara Alejandra',NULL,'STUDENT'),('987654321','TI','María García',NULL,'STUDENT');
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
INSERT INTO `teachers_tbl` VALUES ('jaime.garzon@colegio.edu.co','78273450','CC','Jaime Andres Garzon','3231334788','Biologia','TEACHER','1107974062'),('rufo.ramirez@colegio.com','988790243','CC','Rufo de dios Ramirez','3001234511','Filosofia','TEACHER','1107974062');
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

-- Dump completed on 2026-02-05  0:07:27
