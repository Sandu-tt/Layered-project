--

-- --------------------------------------------------------

SHOW DATABASES;
CREATE DATABASE DayCare;
USE DayCare;



CREATE TABLE children (
                          cID varchar(50) NOT NULL,
                          cName varchar(255) NOT NULL,
                          cAddress varchar(60),
                          dob date NOT NULL,
                          age int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

SHOW TABLES;
DESC children;


CREATE TABLE classroom (
                           crNo varchar(50) NOT NULL,
                           tName varchar(255) NOT NULL,
                           tID varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
SHOW TABLES;
DESC classroom;

CREATE TABLE employee (
                          eNo varchar(50) NOT NULL,
                          eName varchar(255) NOT NULL,
                          eAddress varchar(255) NOT NULL,
                          ePhone varchar(13) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE lookafter (
                           cID varchar(50) NOT NULL,
                           eNo varchar(50) NOT NULL,
                           date date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE nurse (
                       nName varchar(255) NOT NULL,
                       eNo varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE parent (
                        pID varchar(50) NOT NULL,
                        pPhone varchar(13) NOT NULL,
                        c_Name varchar(40) NOT NULL,
                        cID varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE payment (
                         pmID varchar(50) NOT NULL,
                         cID varchar(50) NOT NULL,
                         c_Name varchar(40) NOT NULL,
                         amount double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE salary (
                        sID varchar(50) NOT NULL,
                        eNo varchar(50) NOT NULL,
                        eName varchar(255) NOT NULL,
                        amount double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE teacher (
                         eNo varchar(50) NOT NULL,
                         subject varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



CREATE TABLE user (
                      eNo varchar(50) NOT NULL,
                      userName varchar(50) NOT NULL,
                      password varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



CREATE TABLE vehicle (
                         vID varchar(50) NOT NULL,
                         vehicleType varchar(100) NOT NULL,
                         vehicleName varchar(255) NOT NULL,
                         cID varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `children`
--
ALTER TABLE children
    ADD PRIMARY KEY (cID);

--
-- Indexes for table `classroom`
--
ALTER TABLE classroom
    ADD PRIMARY KEY (crNo),
  ADD KEY `tID` (tID);

--
-- Indexes for table `employee`
--
ALTER TABLE employee
    ADD PRIMARY KEY (eNo);

--
-- Indexes for table `lookafter`
--
ALTER TABLE lookafter
    ADD PRIMARY KEY (cID,eNo),
  ADD KEY eNo (eNo),
  ADD KEY (cID);

--
-- Indexes for table `nurse`
--
ALTER TABLE nurse
    ADD PRIMARY KEY (eNo);

--
-- Indexes for table `parent`
--
ALTER TABLE parent
    ADD PRIMARY KEY (pID),
  ADD KEY cID (cID);

--
-- Indexes for table `payment`
--
ALTER TABLE payment
    ADD PRIMARY KEY (pmID),
  ADD KEY cID (cID);

--
-- Indexes for table `salary`
--
ALTER TABLE salary
    ADD PRIMARY KEY (sID ),
  ADD KEY eNo (eNo);

--
-- Indexes for table `teacher`
--
ALTER TABLE teacher
    ADD PRIMARY KEY (eNo);

--
-- Indexes for table `user`
--
ALTER TABLE user
    ADD PRIMARY KEY (eNo);

--
-- Indexes for table `vehicle`
--
ALTER TABLE vehicle
    ADD PRIMARY KEY (vID),
  ADD KEY `cID` (cID);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `classroom`
--
ALTER TABLE `classroom`
    ADD CONSTRAINT `classroom` FOREIGN KEY (`tID`) REFERENCES `teacher` (`eNo`);

--
-- Constraints for table `lookafter`***********************************

ALTER TABLE `lookafter`
    ADD CONSTRAINT `lookafter_ibfk_1` FOREIGN KEY (`eNo`) REFERENCES `employee` (`eNo`),
  ADD CONSTRAINT `lookafter_ibfk_2` FOREIGN KEY (`cID`) REFERENCES `children` (`cID`);


--
-- Constraints for table `nurse`
--
ALTER TABLE `nurse`
    ADD CONSTRAINT `nurse` FOREIGN KEY (`eNo`) REFERENCES `employee` (`eNo`);

--
-- Constraints for table `parent`
--
ALTER TABLE `parent`
    ADD CONSTRAINT `parent` FOREIGN KEY (`cID`) REFERENCES `children` (`cID`);

Constraint for table `payment`;
**************************
ALTER TABLE `payment`
    ADD CONSTRAINT `payment` FOREIGN KEY (`cID`) REFERENCES `children` (`cID`);


--
-- Constraints for table `salary`

ALTER TABLE salary
    ADD CONSTRAINT salary FOREIGN KEY (eNo) REFERENCES employee (eNo);

--
-- Constraints for table `teacher`
--
ALTER TABLE `teacher`
    ADD CONSTRAINT `teacher` FOREIGN KEY (`eNo`) REFERENCES `employee` (`eNo`);



--
-- Constraints for table `user`
--
ALTER TABLE `user`
    ADD CONSTRAINT `user` FOREIGN KEY (`eNo`) REFERENCES `employee` (`eNo`);

--
-- Constraints for table `vehicle`
--
ALTER TABLE `vehicle`
    ADD CONSTRAINT `vehicle` FOREIGN KEY (`cID`) REFERENCES `children` (`cID`);
COMMIT;