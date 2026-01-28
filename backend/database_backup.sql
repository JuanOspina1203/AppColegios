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
  `student_identification_number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`book_id`),
  UNIQUE KEY `UKnc3j1b4cm2qtd6c6wcyh3f09e` (`student_identification_number`),
  CONSTRAINT `fk_book_student_identification` FOREIGN KEY (`student_identification_number`) REFERENCES `students_tbl` (`student_identification_number`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books_tbl`
--

LOCK TABLES `books_tbl` WRITE;
/*!40000 ALTER TABLE `books_tbl` DISABLE KEYS */;
INSERT INTO `books_tbl` VALUES (1,'Gabriel García Márquez','Ficción','Cien años de soledad',NULL),(3,'Jorge Luis Borges ACTUALIZADO','Ficción ACTUALIZADO','Ficciones ACTUALIZADO',NULL),(4,'Julio Cortázar','Ficción','Rayuela',NULL),(5,'Isabel Allende','Ficción','La casa de los espíritus',NULL),(6,'J.R.R. Tolkien','Fantasía','El Señor de los Anillos',NULL),(7,'J.K. Rowling','Fantasía','Harry Potter y la piedra filosofal',NULL),(8,'George R.R. Martin','Fantasía','Juego de Tronos',NULL),(9,'Patrick Rothfuss','Fantasía','El nombre del viento',NULL),(10,'Brandon Sanderson','Fantasía','El camino de los reyes',NULL),(11,'Isaac Asimov','Ciencia Ficción','Fundación',NULL),(12,'Frank Herbert','Ciencia Ficción','Dune',NULL),(13,'Philip K. Dick','Ciencia Ficción','¿Sueñan los androides con ovejas eléctricas?',NULL),(14,'Arthur C. Clarke','Ciencia Ficción','2001: Una odisea espacial',NULL),(15,'Ray Bradbury','Ciencia Ficción','Fahrenheit 451',NULL),(16,'Agatha Christie','Misterio','Asesinato en el Orient Express',NULL),(17,'Dan Brown','Thriller','El código Da Vinci',NULL),(18,'Stieg Larsson','Thriller','Los hombres que no amaban a las mujeres',NULL),(19,'Gillian Flynn','Thriller','Perdida',NULL),(20,'Arthur Conan Doyle','Misterio','El sabueso de los Baskerville',NULL),(21,'Jane Austen','Romance','Orgullo y prejuicio',NULL),(22,'Nicholas Sparks','Romance','El diario de Noah',NULL),(23,'Emily Brontë','Romance','Cumbres borrascosas',NULL),(24,'John Green','Romance','Bajo la misma estrella',NULL),(25,'Jojo Moyes','Romance','Yo antes de ti',NULL),(26,'Stephen Hawking','Ciencia','Breve historia del tiempo',NULL),(27,'Yuval Noah Harari','Historia','Sapiens: De animales a dioses',NULL),(28,'Dale Carnegie','Autoayuda','Cómo ganar amigos e influir sobre las personas',NULL),(29,'Viktor Frankl','Psicología','El hombre en busca de sentido',NULL),(30,'James Clear','Autoayuda','Hábitos atómicos',NULL),(31,'Walter Isaacson','Biografía','Steve Jobs',NULL),(32,'Anne Frank','Memorias','El diario de Ana Frank',NULL),(33,'Malala Yousafzai','Biografía','Yo soy Malala',NULL),(34,'Michelle Obama','Memorias','Mi historia',NULL),(35,'Nelson Mandela','Autobiografía','El largo camino hacia la libertad',NULL),(36,'Stephen King','Terror','It (Eso)',NULL),(37,'Edgar Allan Poe','Terror','Cuentos de terror',NULL),(38,'H.P. Lovecraft','Terror','La llamada de Cthulhu',NULL),(39,'Bram Stoker','Terror','Drácula',NULL),(40,'Mary Shelley','Terror','Frankenstein',NULL),(41,'Friedrich Nietzsche','Filosofía','Así habló Zaratustra',NULL),(42,'Platón','Filosofía','La República',NULL),(43,'René Descartes','Filosofía','Discurso del método',NULL),(44,'Séneca','Filosofía','Cartas a Lucilio',NULL),(45,'Marcus Aurelius','Filosofía','Meditaciones',NULL),(46,'Suzanne Collins','Distopía','Los juegos del hambre',NULL),(47,'Veronica Roth','Distopía','Divergente',NULL),(48,'George Orwell','Distopía','1984',NULL),(49,'Aldous Huxley','Distopía','Un mundo feliz',NULL),(50,'Lois Lowry','Distopía','El dador',NULL),(51,'Miguel de Cervantes','Ficción','Don Quijote de la Mancha',NULL),(52,'Gustavo Petro','Romance','A traves de mi ventana','1110466965');
/*!40000 ALTER TABLE `books_tbl` ENABLE KEYS */;
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
  `student_identification_number` varchar(20) NOT NULL,
  `student_identification_type` varchar(255) DEFAULT NULL,
  `student_name` varchar(255) DEFAULT NULL,
  `student_grade_related` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`student_identification_number`),
  UNIQUE KEY `uk_student_identification` (`student_identification_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students_tbl`
--

LOCK TABLES `students_tbl` WRITE;
/*!40000 ALTER TABLE `students_tbl` DISABLE KEYS */;
INSERT INTO `students_tbl` VALUES ('1A','1000012345','RC','Valentina Rodríguez',NULL),('1B','1000012346','RC','Santiago Gómez',NULL),('2A','1000012347','RC','Isabella Martínez',NULL),('2B','1000012348','RC','Mateo López',NULL),('3A','1000012349','RC','Sofía Hernández',NULL),('3B','1000012350','RC','Diego García',NULL),('4A','1000012351','RC','Camila Pérez',NULL),('4B','1000012352','RC','Nicolás Fernández',NULL),('5A','1000012353','RC','Mariana Díaz',NULL),('5B','1000012354','RC','Julián Sánchez',NULL),('6A','1000012355','TI','Lucía Ramírez',NULL),('6B','1000012356','TI','Daniel Castro',NULL),('7A','1000012357','TI','Ximena Torres',NULL),('7B','1000012358','TI','Samuel Ortiz',NULL),('8A','1000012359','TI','Valeria Silva',NULL),('8B','1000012360','TI','Miguel Mendoza',NULL),('9A','1000012361','TI','Ana Vargas',NULL),('9B','1000012362','TI','Juan Camilo Rojas',NULL),('10A','1000012363','CC','Carlos Andrés Herrera',NULL),('10B','1000012364','CC','Laura González',NULL),('1A','1000012365','RC','Alejandro Jiménez',NULL),('1B','1000012366','RC','Paula Ávila',NULL),('2A','1000012367','RC','Felipe Castro',NULL),('2B','1000012368','RC','Daniela Ríos',NULL),('3A','1000012369','RC','Jorge Luis Muñoz',NULL),('3B','1000012370','RC','Adriana Núñez',NULL),('4A','1000012371','RC','Ricardo Peña',NULL),('4B','1000012372','RC','Fernanda Delgado',NULL),('5A','1000012373','RC','Héctor Guzmán',NULL),('5B','1000012374','RC','Elena Romero',NULL),('6A','1000012375','TI','Raúl Ortega',NULL),('6B','1000012376','TI','Patricia Marín',NULL),('7A','1000012377','TI','Roberto Salazar',NULL),('7B','1000012378','TI','Tatiana Vega',NULL),('8A','1000012379','TI','Cristian Flores',NULL),('8B','1000012380','TI','Claudia Medina',NULL),('9A','1000012381','TI','Gustavo Navarro',NULL),('9B','1000012382','TI','Diana Paredes',NULL),('1A','1000012383','RC','Luis Fernando Acosta',NULL),('1B','1000012384','RC','Verónica Carrillo',NULL),('2A','1000012385','RC','Edison Franco',NULL),('2B','1000012386','RC','Liliana Ponce',NULL),('3A','1000012387','RC','Hugo Vera',NULL),('3B','1000012388','RC','Silvia Zambrano',NULL),('4A','1000012389','RC','Rafael Aguirre',NULL),('4B','1000012390','RC','Alicia Cáceres',NULL),('5A','1000012391','RC','Esteban Molina',NULL),('5B','1000012392','RC','Yolanda León',NULL),('6A','1000012393','TI','Fabian Quintero',NULL),('6B','1000012394','TI','Beatriz Valencia',NULL),('7A','1000012395','TI','Milton Parra',NULL),('7B','1000012396','TI','Rocío Méndez',NULL),('8A','1000012397','TI','Wilson Cárdenas',NULL),('8B','1000012398','TI','Olga Lozano',NULL),('9A','1000012399','TI','Pablo Escobar',NULL),('9B','1000012400','TI','Carmen Rosa Fuentes',NULL),('1A','1000012401','RC','Johan Smith',NULL),('1B','1000012402','RC','Danna Johnson',NULL),('2A','1000012403','RC','Steven Williams',NULL),('2B','1000012404','RC','Melissa Brown',NULL),('3A','1000012405','RC','Brian Jones',NULL),('3B','1000012406','RC','Vanessa Davis',NULL),('4A','1000012407','RC','Jason Miller',NULL),('4B','1000012408','RC','Stephanie Wilson',NULL),('5A','1000012409','RC','Kevin Taylor',NULL),('5B','1000012410','RC','Nicole Anderson',NULL),('6A','1000012411','TI','Brandon Thomas',NULL),('6B','1000012412','TI','Christina Jackson',NULL),('7A','1000012413','TI','Gary White',NULL),('7B','1000012414','TI','Rachel Harris',NULL),('8A','1000012415','TI','Eric Martin',NULL),('8B','1000012416','TI','Amanda Thompson',NULL),('9A','1000012417','TI','Scott Garcia',NULL),('9B','1000012418','TI','Tiffany Martinez',NULL),('1A','1000012419','RC','Eduardo Hall',NULL),('1B','1000012420','RC','Gabriela Allen',NULL),('2A','1000012421','RC','José Young',NULL),('2B','1000012422','RC','Paulina King',NULL),('3A','1000012423','RC','Manuel Wright',NULL),('3B','1000012424','RC','Elena Scott',NULL),('4A','1000012425','RC','Pedro Torres',NULL),('4B','1000012426','RC','Rosa Nguyen',NULL),('5A','1000012427','RC','Francisco Hill',NULL),('5B','1000012428','RC','Luisa Flores',NULL),('6A','1000012429','TI','Javier Green',NULL),('6B','1000012430','TI','Marta Adams',NULL),('7A','1000012431','TI','Raul Nelson',NULL),('7B','1000012432','TI','Teresa Baker',NULL),('8A','1000012433','TI','Alfonso Carter',NULL),('8B','1000012434','TI','Ruth Mitchell',NULL),('9A','1000012435','TI','Antonio Pérez',NULL),('9B','1000012436','TI','Eva Roberts',NULL),('10A','1001234567','CC','Juan Camilo Pérez',NULL),('10B','1001234568','CC','María Fernanda González',NULL),('11A','1001234569','TI','Carlos Andrés Rodríguez',NULL),('11B','1001234570','TI','Ana Sofía Martínez',NULL),('9A','1001234571','RC','Sebastián López',NULL),('9B','1001234572','RC','Valentina Sánchez',NULL),('12A','1001234573','CC','Andrés Felipe Ramírez',NULL),('12B','1001234574','CC','Isabella Torres',NULL),('10A','1001234575','TI','Mateo Herrera',NULL),('10B','1001234576','CC','Sofía Castro',NULL),('11A','1001234577','TI','Samuel Díaz',NULL),('11B','1001234578','CC','Mariana Ortega',NULL),('9A','1001234579','RC','Daniel Gómez',NULL),('9B','1001234580','RC','Gabriela Mendoza',NULL),('12A','1001234581','CC','David Jiménez',NULL),('12B','1001234582','CC','Camila Ruiz',NULL),('10A','1001234583','TI','Julián Silva',NULL),('10B','1001234584','CC','Lucía Vargas',NULL),('11A','1001234585','TI','Tomás Rojas',NULL),('11B','1001234586','CC','Antonella Flores',NULL),('9A','1001234587','RC','Emilio Reyes',NULL),('9B','1001234588','RC','Victoria Núñez',NULL),('12A','1001234589','CC','Felipe Peña',NULL),('12B','1001234590','CC','Ximena Delgado',NULL),('10A','1001234591','TI','Ricardo Morales',NULL),('10B','1001234592','CC','Daniela Suárez',NULL),('11A','1001234593','TI','Alejandro Vega',NULL),('11B','1001234594','CC','Paola Romero',NULL),('9A','1001234595','RC','Hugo Aguilar',NULL),('9B','1001234596','RC','Natalia Paredes',NULL),('12A','1001234597','CE','Kevin Smith',NULL),('12B','1001234598','CE','Emily Johnson',NULL),('10A','1001234599','TI','Leonardo Medina',NULL),('10B','1001234600','CC','Fernanda Castillo',NULL),('11A','1001234601','TI','Gonzalo Navarro',NULL),('11B','1001234602','CC','Catalina Bravo',NULL),('9A','1001234603','RC','Rodrigo Salazar',NULL),('9B','1001234604','RC','Constanza Tapia',NULL),('12A','1001234605','CC','Patrick Wilson',NULL),('12B','1001234606','CE','Sophia Brown',NULL),('10A','1001234607','TI','Alexis Cordero',NULL),('10B','1001234608','CC','Javiera Sepúlveda',NULL),('11A','1001234609','TI','Maximiliano Guzmán',NULL),('11B','1001234610','CC','Florencia Ríos',NULL),('9A','1001234611','RC','Benjamín Espinoza',NULL),('9B','1001234612','RC','Martina Contreras',NULL),('12A','1001234613','PAS','Robert Davis',NULL),('12B','1001234614','PAS','Olivia Miller',NULL),('10A','1001234615','TI','Álvaro Fuentes',NULL),('10B','1001234616','CC','Bárbara Molina',NULL),('11A','1101234567','CC','Andrés Felipe Castillo',NULL),('11B','1101234568','CC','Gabriela Morales',NULL),('12A','1101234569','CC','David Alejandro Ruiz',NULL),('12B','1101234570','CC','Carolina Soto',NULL),('10A','1101234571','CC','Óscar Cordero',NULL),('10B','1101234572','CC','Rosa Elena Bravo',NULL),('11A','1101234573','CC','Mauricio Sepúlveda',NULL),('11B','1101234574','CC','Julia Tapia',NULL),('12A','1101234575','CC','Walter Rueda',NULL),('12B','1101234576','CC','Natalia Espinoza',NULL),('10A','1101234577','CC','Alberto Montoya',NULL),('10B','1101234578','CC','Sara Restrepo',NULL),('11A','1101234579','CC','Fabián Giraldo',NULL),('11B','1101234580','CC','Monica Londoño',NULL),('12A','1101234581','CC','Harold Suárez',NULL),('12B','1101234582','CC','Angela María Arias',NULL),('10A','1101234583','CC','Justin Robinson',NULL),('10B','1101234584','CC','Brittany Clark',NULL),('11A','1101234585','CC','Alexander Rodríguez',NULL),('11B','1101234586','CC','Victoria Lewis',NULL),('12A','1101234587','CC','Patrick Lee',NULL),('12B','1101234588','CC','Jennifer Walker',NULL),('10A','1101234589','CC','Ramon Turner',NULL),('10B','1101234590','CC','Irene Phillips',NULL),('11A','1101234591','CC','Enrique Campbell',NULL),('11B','1101234592','CC','Consuelo Parker',NULL),('12A','1101234593','CC','Sergio Evans',NULL),('12B','1101234594','CC','Aurora Edwards',NULL),('6A','1110466965','TI','Kelly Alejandra Ramirez Guzman','6A'),('1C','2001234561','RC','Ignacio Rojas Pérez',NULL),('1D','2001234562','RC','Emilia Sánchez López',NULL),('2C','2001234563','RC','Bruno Díaz Castro',NULL),('2D','2001234564','RC','Catalina Ramírez Ortiz',NULL),('3C','2001234565','RC','Luca Fernández García',NULL),('3D','2001234566','RC','Zoe Martínez Rodríguez',NULL),('4C','2001234567','RC','Thiago González Silva',NULL),('4D','2001234568','RC','Aitana Morales Ruiz',NULL),('5C','2001234569','TI','Dylan Hernández Vega',NULL),('5D','2001234570','TI','Valentina Peña Cruz',NULL),('6C','2001234571','TI','Axel Díaz Ortega',NULL),('6D','2001234572','TI','Luna Mendoza Reyes',NULL),('7C','2001234573','TI','Ian Gutiérrez Delgado',NULL),('7D','2001234574','TI','Mía Núñez Herrera',NULL),('8C','2001234575','TI','Eithan Jiménez Castro',NULL),('8D','2001234576','TI','Abril Paredes Navarro',NULL),('9C','2001234577','CC','Sebastián Ríos Fuentes',NULL),('9D','2001234578','CC','Renata Salazar Bravo',NULL),('10C','2001234579','CC','Diego Espinoza Cordero',NULL),('10D','2001234580','CC','Antonella Tapia Ávila',NULL),('11C','2001234581','CC','Samuel Molina Romero',NULL),('11D','2001234582','CC','Julieta Aguilar Guzmán',NULL),('12C','2001234583','CC','Gabriel Sepúlveda Flores',NULL),('12D','2001234584','CC','Sofía Miranda Torres',NULL),('1A','3001234501','RC','Amir Khan',NULL),('1B','3001234502','RC','Lila Chen',NULL),('2A','3001234503','RC','Dante Rossi',NULL),('2B','3001234504','RC','Anika Schmidt',NULL),('3A','3001234505','RC','Kaito Tanaka',NULL),('3B','3001234506','RC','Maya Dubois',NULL),('4A','3001234507','RC','Rohan Patel',NULL),('4B','3001234508','RC','Chiara Ferrari',NULL),('5A','3001234509','TI','Oliver Johansson',NULL),('5B','3001234510','TI','Yara Ivanova',NULL),('6A','3001234511','TI','Elias Novak',NULL),('6B','3001234512','TI','Noor Al-Farsi',NULL),('7A','3001234513','TI','Leandro Costa',NULL),('7B','3001234514','TI','Freya Andersen',NULL),('8A','3001234515','TI','Mateusz Kowalski',NULL),('8B','3001234516','TI','Isabella Santos',NULL),('9A','4001234501','PAS','Lucas Martínez (silla de ruedas)',NULL),('10B','4001234502','PAS','Martina Rodríguez (hipoacusia)',NULL),('11A','4001234503','PAS','Facundo López (visión reducida)',NULL),('12B','4001234504','PAS','Florencia García (TEA)',NULL),('10A','5001234501','CE','William Smith (USA)',NULL),('10B','5001234502','CE','Sophie Martin (France)',NULL),('11A','5001234503','CE','Liam Johnson (Canada)',NULL),('11B','5001234504','CE','Emma Wilson (Australia)',NULL),('12A','5001234505','CE','Noah Brown (UK)',NULL),('12B','5001234506','CE','Olivia Taylor (New Zealand)',NULL),('6C','6001234501','TI','Juan Carlos Pérez Rodríguez',NULL),('7D','6001234502','TI','María José González López',NULL),('8C','6001234503','TI','José Antonio Martínez Sánchez',NULL),('9D','6001234504','CC','Ana María Fernández García',NULL),('10C','6001234505','CC','Luis Miguel Díaz Castro',NULL),('11D','6001234506','CC','Laura Patricia Ramírez Ortiz',NULL),('1A','7001234501','RC','Benjamín Herrera',NULL),('1B','7001234502','RC','Alma Rodríguez',NULL),('2A','7001234503','RC','Maximiliano Castro',NULL),('2B','7001234504','RC','Delfina Navarro',NULL),('3A','7001234505','RC','Joaquín Salazar',NULL),('3B','7001234506','RC','Agustina Fuentes',NULL),('4A','7001234507','RC','Tadeo Bravo',NULL),('4B','7001234508','RC','Celeste Espinoza',NULL),('5A','7001234509','TI','Bautista Cordero',NULL),('5B','7001234510','TI','Jazmín Tapia',NULL),('6A','7001234511','TI','Santino Ávila',NULL),('6B','7001234512','TI','Bianca Molina',NULL),('7A','7001234513','TI','Lorenzo Romero',NULL),('7B','7001234514','TI','Morena Aguilar',NULL),('8A','7001234515','TI','Tiziano Guzmán',NULL),('8B','7001234516','TI','Luciana Sepúlveda',NULL),('9A','7001234517','CC','Salvatore Flores',NULL),('9B','7001234518','CC','Giuliana Miranda',NULL),('10A','7001234519','CC','Damián Torres',NULL),('10B','7001234520','CC','Alondra Vargas',NULL),('11A','7001234521','CC','Marcelo Contreras',NULL),('11B','7001234522','CC','Catalina Soto',NULL),('12A','7001234523','CC','Rafael Muñoz',NULL),('12B','7001234524','CC','Victoria Pérez',NULL),('4C','8001234501','RC','Wayra Mamani',NULL),('5C','8001234502','TI','Inti Quispe',NULL),('6C','8001234503','TI','Killa Chávez',NULL),('7C','8001234504','TI','Yaku Condori',NULL),('8C','8001234505','TI','Pacha Huanca',NULL),('9C','8001234506','CC','Sami Yupanqui',NULL),('1C','9001234501','RC','Francisco Javier',NULL),('2C','9001234502','RC','María de los Ángeles',NULL),('3C','9001234503','RC','José María',NULL),('4D','9001234504','RC','Ana Teresa',NULL),('5D','9001234505','TI','Juan Pablo',NULL),('6D','9001234506','TI','Rosa Elena',NULL),('7D','9001234507','TI','Miguel Ángel',NULL),('8D','9001234508','TI','Carmen Cecilia',NULL),('9D','9001234509','CC','Pedro Antonio',NULL),('10D','9001234510','CC','Luisa Fernanda',NULL),('11D','9001234511','CC','Alberto José',NULL),('12D','9001234512','CC','Elena María',NULL),('1D','9101234501','RC','Nicolás Alejandro',NULL),('2D','9101234502','RC','Gabriela Isabel',NULL),('3D','9101234503','RC','Ricardo Andrés',NULL),('4C','9101234504','RC','Patricia Carolina',NULL),('5C','9101234505','TI','Federico Manuel',NULL),('6C','9101234506','TI','Verónica Andrea',NULL),('7C','9101234507','TI','Guillermo Esteban',NULL),('8C','9101234508','TI','Claudia Marcela',NULL),('9C','9101234509','CC','Humberto Rafael',NULL),('10C','9101234510','CC','Adriana Lucía',NULL),('11C','9101234511','CC','Mauricio David',NULL),('12C','9101234512','CC','Ximena Patricia',NULL),('1A','9201234501','RC','Cristóbal Ignacio',NULL),('2A','9201234502','RC','Pamela Alejandra',NULL),('3A','9201234503','RC','Rodrigo Felipe',NULL),('4A','9201234504','RC','Carolina Daniela',NULL),('5A','9201234505','TI','Fabián Leonardo',NULL),('6A','9201234506','TI','Paulina Victoria',NULL),('7A','9201234507','TI','Cristian Omar',NULL),('8A','9201234508','TI','Javiera Francisca',NULL),('9A','9201234509','CC','Héctor Alejandro',NULL),('10A','9201234510','CC','Macarena Antonia',NULL),('11A','9201234511','CC','Víctor Manuel',NULL),('12A','9201234512','CC','Francisca Ignacia',NULL),('1B','9301234501','RC','Esteban Nicolás',NULL),('2B','9301234502','RC','Daniela Paz',NULL),('3B','9301234503','RC','Alejandro Javier',NULL),('4B','9301234504','RC','Katherine Nicole',NULL),('5B','9301234505','TI','Pablo Andrés',NULL),('6B','9301234506','TI','María Soledad',NULL),('7B','9301234507','TI','Luis Fernando',NULL),('8B','9301234508','TI','Camila Belén',NULL),('9B','9301234509','CC','Gustavo Adolfo',NULL),('10B','9301234510','CC','Constanza Andrea',NULL),('11B','9301234511','CC','Nelson Eduardo',NULL),('12B','9301234512','CC','Bárbara Alejandra',NULL),('11B','987654321','TI','María García',NULL);
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
  PRIMARY KEY (`teacher_identification_number`),
  UNIQUE KEY `uk_teacher_identification` (`teacher_identification_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teachers_tbl`
--

LOCK TABLES `teachers_tbl` WRITE;
/*!40000 ALTER TABLE `teachers_tbl` DISABLE KEYS */;
INSERT INTO `teachers_tbl` VALUES ('rufo.ramirez@colegio.edu.co','988790243','CC','Rufo de dios Ramirez','3001234511','Filosofia');
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

-- Dump completed on 2026-01-27 16:24:26
