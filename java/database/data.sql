BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO animals (animal_name, animal_type, breed, gender, age, is_adoptable, description, photo) VALUES ('Billy', 'Goat', 'unknown','Male', 3, true, 'Meet Billy, a 3-year-old male Goat. He is a friendly and social animal. With an energy level of 5, he enjoys a good balance between relaxation and playfulness. Adopt Billy today and add joy to your home!', 'https://res.cloudinary.com/dfg9ft030/image/upload/v1685838320/Billy_Goat_rll8r7.jpg');
INSERT INTO animals (animal_name, animal_type, breed, gender, age, is_adoptable, description, photo) VALUES ('Bowser', 'Dog', 'Bassett Hound', 'Male', 5, true, 'Bowser is a 5-year-old male Bassett Hound. He''s friendly and well-behaved, making him a great family pet. Bowser is neutered and has a moderate energy level (5/10). He gets along well with kids and other animals. Adopt Bowser today!', 'https://res.cloudinary.com/dfg9ft030/image/upload/v1685839140/Bowser_Dog_Bassett_Hound_o6jul6.jpg');
INSERT INTO animals (animal_name, animal_type, breed, gender, age, is_adoptable, description, photo) VALUES ('Tuxedo', 'Cat', 'Tuxedo', 'Female', 7, true,'Tuxedo is a 7-year-old female Tuxedo cat. She has a gentle and friendly temperament, making her a great companion. Tuxedo is spayed, social with kids and other animals, and has a moderate energy level.' ,'https://res.cloudinary.com/dfg9ft030/image/upload/v1685839291/Velvet_Cat_Tuxedo_rqjnsp.jpg');
INSERT INTO animals (animal_name, animal_type, breed, gender, age, is_adoptable, description, photo) VALUES ('Max', 'Cat', 'Tabby', 'Female', 3, true, 'Meet Max, a 3-year-old spayed female Tabby cat. Max is independent and prefers a calm environment without other animals or kids. With an energy level of 4, she enjoys lounging and relaxing.', 'https://res.cloudinary.com/dfg9ft030/image/upload/v1685839558/Si_Tabby_Cat_oswk90.jpg');
INSERT INTO animals (animal_name, animal_type, breed, gender, age, is_adoptable, description, photo) VALUES ('Spike', 'Dog','German Shepherd', 'Male', 2, true, 'Meet Spike, a 2-year-old neutered male German Shepherd. Not social with dogs, great with kids. Energy level 8, loves outdoor adventures. Experienced owners, meet your loyal match!', 'https://res.cloudinary.com/dfg9ft030/image/upload/v1685839817/Spike_German_Sheperd_Dog_rsxif2.jpg');
INSERT INTO animals (animal_name, animal_type, breed, gender, age, is_adoptable, description, photo) VALUES ('Cotton', 'Rabbit', 'Holland Lop','Female', 1, true, 'Introducing Cotton, a spayed female Holland Lop rabbit. Sweet and gentle at 1 year old, she prefers a calm environment and is independent. Energy level 3, loves hopping and exploring. Adopt this adorable fluffball today!', 'https://res.cloudinary.com/dfg9ft030/image/upload/v1685840017/Cotton_Rabbit_ii1ao8.jpg');
INSERT INTO animals (animal_name, animal_type, breed, gender, age, is_adoptable, description, photo) VALUES ('Roux', 'Cat', 'Siamese', 'Male', 4, true, 'Meet Roux, a neutered male Siamese cat. At 4 years old, he''s affectionate and playful, getting along well with kids and other animals. With an energy level of 7, he''s always up for interactive playtime. Adopt this charming feline companion today! ','https://res.cloudinary.com/dfg9ft030/image/upload/v1685840296/Roux_Siamese_Cat_j0m2kv.jpg');
INSERT INTO animals (animal_name, animal_type, breed, gender, age, is_adoptable, description, photo) VALUES ('Buddy', 'Dog', 'Golden Retriever', 'Male', 3, true, 'Buddy is a friendly and neutered male Golden Retriever. At 3 years old, he''s great with kids and other animals. Buddy''s energy level is a balanced 6, making him a delightful companion for active adventures or relaxing cuddle sessions.', 'https://res.cloudinary.com/dfg9ft030/image/upload/v1685840634/Buddy_Golden_Retriever_Dog_zexlss.jpg');
INSERT INTO animals (animal_name, animal_type, breed, gender, age, is_adoptable, description, photo) VALUES ('Peanut', 'Hamster', 'Syrian','Male', 1, true, 'Introducing Peanut, an adorable and adoptable male Syrian hamster. At just 1 year old, Peanut is full of energy, scoring a playful 8 on the scale. With his friendly demeanor and gentle temperament, he makes a perfect pet for kids.','https://res.cloudinary.com/dfg9ft030/image/upload/v1685840828/Peanut_Hamster_luobge.jpg');
INSERT INTO animals (animal_name, animal_type, breed, gender, age, is_adoptable, description, photo) VALUES ('Whiskers', 'Rabbit', 'Netherland Dwarf', 'Female', 2, true, 'Meet Whiskers, a female Netherland Dwarf rabbit. Although not social, Whiskers is independent and enjoys her own space. With a calm temperament and an energy level of 4, she''s perfect for a quieter home.', 'https://res.cloudinary.com/dfg9ft030/image/upload/v1685840940/Whiskers_Rabbit_ofhtsp.jpg');
INSERT INTO animals (animal_name, animal_type, breed, gender, age, is_adoptable, description, photo) VALUES ('Milo', 'Cat', 'Maine Coon', 'Male', 5, true, 'Milo is a friendly male Maine Coon cat. He has a calm temperament and loves to interact with kids. However, Milo is not fond of dogs. With an energy level of 4, he enjoys both playtime and relaxation. Milo is neutered and ready for a loving home.','https://res.cloudinary.com/dfg9ft030/image/upload/v1685841350/Milo_Maine_Coon_Cat_cs1bxz.png');
INSERT INTO animals (animal_name, animal_type, breed, gender, age, is_adoptable, description, photo) VALUES ('Rocky', 'Dog','Bulldog','Male', 6, true ,'Introducing Rocky, a sociable and neutered male Bulldog. With a temperament that''s friendly and gentle, he''s great with both kids and other animals. Rocky, at 6 years old, has an energy level of 6, making him an active and playful companion.','https://res.cloudinary.com/dfg9ft030/image/upload/v1685841561/Rocky_Bulldog_Dog_vsa9ew.jpg');
INSERT INTO animals (animal_name, animal_type, breed, gender, age, is_adoptable, description, photo) VALUES ('Nibbles', 'Guinea Pig', 'American', 'Female', 1, true, 'Meet Nibbles, a sweet and sociable female Guinea Pig. With a friendly temperament, she thrives in the company of another Guinea Pig companion. Nibbles, at 1 year old, has an energy level of 4, making her an active and curious pet.','https://res.cloudinary.com/dfg9ft030/image/upload/v1685841717/Nibbles_Guinea_Pig_jvvgi6.jpg');
INSERT INTO animals (animal_name, animal_type, breed, gender, age, is_adoptable, description, photo) VALUES ('Simba', 'Cat', 'Bengal', 'Male', 3, true , 'Simba is a stunning male Bengal cat with a playful and social nature. This 3-year-old feline is neutered and ready to find his forever home. With an energy level of 6, Simba loves interactive playtime and will bring endless joy to your household.', 'https://res.cloudinary.com/dfg9ft030/image/upload/v1685841826/Simba_Bengal_Cat_skvsza.jpg');
INSERT INTO animals (animal_name, animal_type, breed, gender, age, is_adoptable, description, photo) VALUES ('Lucky', 'Dog','Labrador Retriever', 'Female', 4,  true, 'Lucky is a spayed female Labrador Retriever! She is a social dog, who loves the company of other animals and kids. With her gentle temperament, she''s also great with older people.  Lucky''s energy level is a 3, making her a calm companion.', 'https://res.cloudinary.com/dfg9ft030/image/upload/v1685841912/Lucky_Labrador_Dog_tkhlcg.jpg');
INSERT INTO animals (animal_name, animal_type, breed, gender, age, is_adoptable, description, photo) VALUES ('Bella', 'Rabbit', 'Flemish Giant', 'Female', 3,  true, 'Meet Bella, a spayed female Flemish Giant rabbit! She loves interacting with humans and enjoys being petted. With an energy level of 5, she enjoys hopping around and exploring her surroundings.', 'https://res.cloudinary.com/dfg9ft030/image/upload/v1685841969/Bella_Rabbit_ze3wzf.jpg');
INSERT INTO animals (animal_name, animal_type, breed, gender, age, is_adoptable, description, photo) VALUES ('Oscar', 'Cat', 'Persian', 'Male', 2,  true, 'Oscar is a charming and spayed male Persian cat! Oscar has a gentle temperament, making him an ideal companion for anyone. He is social and gets along well with other animals, and kids. With an energy level of 7, Oscar loves to play and explore.', 'https://res.cloudinary.com/dfg9ft030/image/upload/v1685842025/Oscar_Persian_Cat_zymzqn.jpg');
INSERT INTO animals (animal_name, animal_type, breed, gender, age, is_adoptable, description, photo) VALUES ('Charlie', 'Dog','Poodle', 'Male', 1, true, 'Charlie is a spayed male Poodle who is ready to steal your heart! Charlie is a great companion for families. He gets along well with other dogs and enjoys the company of people. With an energy level of 6, Charlie loves to play and go for walks.', 'https://res.cloudinary.com/dfg9ft030/image/upload/v1685842102/Charlie_Poodle_Dog_oc34yp.jpg');
INSERT INTO animals (animal_name, animal_type, breed, gender, age, is_adoptable, description, photo) VALUES ('Patches', 'Cat', 'Calico',  'Female', 2, true , 'Meet Patches, a spayed female Calico Cat. Patches is an affectionate feline who loves human company. She enjoys spending time outdoors, exploring and basking in the sunshine. With an energy level of 6, she''s ready for playful adventures.', 'https://res.cloudinary.com/dfg9ft030/image/upload/v1685842208/Patches_Calico_Cat_i4wskh.jpg');
INSERT INTO animals (animal_name, animal_type, breed, gender, age, is_adoptable, description, photo) VALUES ('Cooper', 'Dog', 'Boxer', 'Male', 5, true, 'Cooper is a spayed male Boxer. At 5-years-old, he has a friendly and social temperament. Cooper loves the outdoors and has an energy level of 8, making him a perfect companion for active individuals or families.', 'https://res.cloudinary.com/dfg9ft030/image/upload/v1685842305/Cooper_Boxer_Dog_ww8fwz.jpg');
INSERT INTO animals (animal_name, animal_type, breed, gender, age, is_adoptable, description, photo) VALUES ('Lola', 'Rabbit', 'Mini Rex', 'Female', 1, true, 'Meet Lola, a cute female Mini Rex rabbit. At just 1 year old, she is full of energy and loves to explore her surroundings. Lola is friendly and social, making her a great companion for both kids and adults.', 'https://res.cloudinary.com/dfg9ft030/image/upload/v1685843276/Lola_Rabbit_mzdgcl.jpg');
INSERT INTO animals (animal_name, animal_type, breed, gender, age, is_adoptable, description, photo) VALUES ('Shadow', 'Cat', 'Russian Blue','Male', 4,  true, 'Shadow is a handsome, neutered male Russian Blue cat. At 4 years old, he is known for his elegant and mysterious nature. With an energy level of 3, Shadow is an affectionate companion who enjoys spending quality time with his family.', 'https://res.cloudinary.com/dfg9ft030/image/upload/v1685843387/Shadow_Russian_Blue_Cat_utkpxf.jpg');
INSERT INTO animals (animal_name, animal_type, breed, gender, age, is_adoptable, description, photo) VALUES ('Max', 'Dog', 'Beagle', 'Male', 3, true, 'Max is a friendly and energetic male Beagle. At 3 years old, he is full of life with an energy level of 7. Max is a social dog who gets along well with both humans and animals. With his playful nature he will make a wonderful addition to any family.', 'https://res.cloudinary.com/dfg9ft030/image/upload/v1685843517/Max_Beagle_Dog_k55qko.jpg');
INSERT INTO animals (animal_name, animal_type, breed, gender, age, is_adoptable, description, photo) VALUES ('Daisy', 'Cat', 'Tabby', 'Female', 1, true, 'Daisy is an independent female Tabby cat. At just 1 year old, she prefers her own space and enjoys exploring her surroundings. With an energy level of 2, Daisy would make a wonderful addition to a quiet and understanding home', 'https://res.cloudinary.com/dfg9ft030/image/upload/v1685843891/Daisy_Tabby_Cat_dzhfqz.jpg');
INSERT INTO animals (animal_name, animal_type, breed, gender, age, is_adoptable, description, photo) VALUES ('Bailey', 'Dog', 'Siberian Husky','Female', 6, true, 'Bailey is a spayed female Siberian Husky. At 6 years old, Bailey is a spirited companion. With an energy level of 9, Bailey thrives on being outdoors, making her an ideal partner for outdoor adventures.', 'https://res.cloudinary.com/dfg9ft030/image/upload/v1685844027/Bailey_Siberian_Huskey_Dog_oimze9.jpg');
INSERT INTO animals (animal_name, animal_type, breed, gender, age, is_adoptable, description, photo) VALUES ('Coco', 'Rabbit', 'Lionhead','Female', 2,  true, 'Meet Coco, a 2-year-old female Lionhead rabbit. Coco is a friendly and sociable bunny who loves human interaction. With a moderate energy level, she is an ideal pet for both playtime and cuddles. Adopt this adorable furry companion today!', 'https://res.cloudinary.com/dfg9ft030/image/upload/v1685844100/Coco_Rabbit_k0dclz.jpg');
INSERT INTO animals (animal_name, animal_type, breed, gender, age, is_adoptable, description, photo) VALUES ('Leo', 'Cat', 'Scottish Fold','Male', 7,  true, 'Introducing Leo, a 7-year-old male Scottish Fold cat. Leo is a calm and affectionate companion with an energy level of 3 who enjoys a relaxed lifestyle. He is neutered and ready to find his forever home. Consider adopting this charming feline today!', 'https://res.cloudinary.com/dfg9ft030/image/upload/v1685844244/Leo_Scottish_Fold_Cat_zvbf1g.jpg');
INSERT INTO animals (animal_name, animal_type, breed, gender, age, is_adoptable, description, photo) VALUES ('Lucy', 'Dog','Dachshund', 'Female', 2,  true, 'Meet Lucy, a 2-year-old female Dachshund. Lucy is a friendly and playful companion who loves to explore and go on adventures. She is spayed and ready to join a loving family. Adopt this adorable pup today and experience endless joy and wagging tails!',  'https://res.cloudinary.com/dfg9ft030/image/upload/v1685844462/Lucy_Dachsund_Dog_mi84dq.jpg');
INSERT INTO animals (animal_name, animal_type, breed, gender, age, is_adoptable, description, photo) VALUES ('Oliver', 'Cat', 'Ragdoll', 'Male', 5,  true, 'Oliver is a 5-year-old male Ragdoll cat. Oliver is known for his calm and gentle nature. He loves to be pampered and enjoys lounging around. With his beautiful blue eyes and fluffy coat, Oliver is the perfect companion for relaxation and cuddles.', 'https://res.cloudinary.com/dfg9ft030/image/upload/v1685844587/Oliver_Ragdoll_Cat_hmtd5p.jpg');
INSERT INTO animals (animal_name, animal_type, breed, gender, age, is_adoptable, description, photo) VALUES ('Oreo', 'Rabbit', 'Dutch', 'Male', 3,  true, 'Meet Oreo, a 3-year-old male Dutch rabbit. Oreo is an adorable bundle of energy and loves to explore his surroundings. With his striking black and white markings, he is sure to capture your heart. Oreo is neutered and ready for adoption.', 'https://res.cloudinary.com/dfg9ft030/image/upload/v1685844651/Oreo_Rabbit_c9yv71.jpg');

INSERT INTO applications (first_name, last_name, date_of_birth, home_address, availability, school_mascot, email, phone_number, opt_in_text, experience, transportation, bkgrnd_check_approved, admin_approval, photo) VALUES ('Jim', 'Trussel', '1962-10-10', '5555 Morningglory Ct., Portland, OR, 97218',
        '18', 'Trojan', 'jtruss@aol.com', '555-897-0543', true, false, true, 'Pending', 'Pending', 'https://res.cloudinary.com/dfg9ft030/image/upload/v1686063151/Volunteers/Trussel_Jim_daq4za.jpg');
INSERT INTO applications (first_name, last_name, date_of_birth, home_address, availability, school_mascot, email, phone_number, opt_in_text, experience, transportation, bkgrnd_check_approved, admin_approval, photo) VALUES ('Nicole', 'Win', '2000-08-17', '999 Juniper St., Portland, OR, 97220',
        '10', 'Bulldogs', 'nwinning99@gmail.com', '555-213-9945', true, true, false, 'Pending', 'Pending', 'https://res.cloudinary.com/dfg9ft030/image/upload/v1686063363/Volunteers/Nicole_Win_pmjk9w.jpg');
INSERT INTO applications (first_name, last_name, date_of_birth, home_address, availability, school_mascot, email, phone_number, opt_in_text, experience, transportation, bkgrnd_check_approved, admin_approval, photo) VALUES ('John', 'Smith', '1955-02-01', '777 Apple Rd., Portland, OR, 97218',
        '25', 'Eagles', 'JohnSmith1234@hotmail.com', '555-898-1735', false, true, true, 'Pending', 'Pending', 'https://res.cloudinary.com/dfg9ft030/image/upload/v1686063449/Volunteers/Smith_John_swvvbo.jpg');
INSERT INTO applications (first_name, last_name, date_of_birth, home_address, availability, school_mascot, email, phone_number, opt_in_text, experience, transportation, bkgrnd_check_approved, admin_approval, photo) VALUES ('Jane', 'Doe', '1995-06-12', '123 Main St., Seattle, WA, 98101',
 '40', 'Tigers', 'JaneDoe5678@gmail.com', '555-123-4567', true, false, true, 'Approved', 'Pending', 'https://res.cloudinary.com/dfg9ft030/image/upload/v1686063587/Volunteers/Doe_Jane_gayilh.png');
INSERT INTO applications (first_name, last_name, date_of_birth, home_address, availability, school_mascot, email, phone_number, opt_in_text, experience, transportation, bkgrnd_check_approved, admin_approval, photo) VALUES ('Michael', 'Johnson', '1992-09-22', '456 Oak Ave., Los Angeles, CA, 90001',
 '30', 'Lions', 'MichaelJohnson9012@yahoo.com', '555-987-6543', false, true, false, 'Approved', 'Pending', 'https://res.cloudinary.com/dfg9ft030/image/upload/v1686063816/Volunteers/Johnson_Michael_afz2o5.png');
INSERT INTO applications (first_name, last_name, date_of_birth, home_address, availability, school_mascot, email, phone_number, opt_in_text, experience, transportation, bkgrnd_check_approved, admin_approval, photo) VALUES ('Emily', 'Brown', '1998-03-15', '789 Elm Rd., Chicago, IL, 60601',
 '20', 'Bulldogs', 'EmilyBrown3456@hotmail.com', '555-456-7890', true, true, true, 'Approved', 'Pending', 'https://res.cloudinary.com/dfg9ft030/image/upload/v1686063819/Volunteers/Brown_Emily_wyirco.png');
INSERT INTO applications (first_name, last_name, date_of_birth, home_address, availability, school_mascot, email, phone_number, opt_in_text, experience, transportation, bkgrnd_check_approved, admin_approval, photo) VALUES ('David', 'Davis', '1988-11-28', '321 Pine St., Denver, CO, 80202',
 '35', 'Panthers', 'DavidDavis7890@gmail.com', '555-234-5678', true, false, true, 'Rejected', 'Pending', 'https://res.cloudinary.com/dfg9ft030/image/upload/v1686063819/Volunteers/Davis_David_lkqgir.png');
INSERT INTO applications (first_name, last_name, date_of_birth, home_address, availability, school_mascot, email, phone_number, opt_in_text, experience, transportation, bkgrnd_check_approved, admin_approval, photo) VALUES ('Sarah', 'Wilson', '1994-07-09', '987 Cedar Ave., San Francisco, CA, 94101',
 '15', 'Hawks', 'SarahWilson2345@yahoo.com', '555-567-8901', false, true, true, 'Pending', 'Pending', 'https://res.cloudinary.com/dfg9ft030/image/upload/v1686063814/Volunteers/Wilson_Sarah_lzj222.jpg');
INSERT INTO applications (first_name, last_name, date_of_birth, home_address, availability, school_mascot, email, phone_number, opt_in_text, experience, transportation, bkgrnd_check_approved, admin_approval, photo) VALUES ('Daniel', 'Taylor', '1996-04-18', '654 Maple Rd., Austin, TX, 78701',
 '40', 'Cougars', 'DanielTaylor6789@hotmail.com', '555-901-2345', true, true, true, 'Approved', 'Pending', 'https://res.cloudinary.com/dfg9ft030/image/upload/v1686063814/Volunteers/Taylor_Daniel_oaxnwz.jpg');
INSERT INTO applications (first_name, last_name, date_of_birth, home_address, availability, school_mascot, email, phone_number, opt_in_text, experience, transportation, bkgrnd_check_approved, admin_approval, photo) VALUES ('Olivia', 'Anderson', '1993-08-25', '321 Oak Ave., Boston, MA, 02101',
 '25', 'Wolves', 'OliviaAnderson0123@gmail.com', '555-345-6789', false, true, true, 'Rejected', 'Pending', 'https://res.cloudinary.com/dfg9ft030/image/upload/v1686063814/Volunteers/Anderson_Olivia_g0wtw3.jpg');
INSERT INTO applications (first_name, last_name, date_of_birth, home_address, availability, school_mascot, email, phone_number, opt_in_text, experience, transportation, bkgrnd_check_approved, admin_approval, photo) VALUES ('Matthew', 'Martinez', '1987-12-04', '789 Pine St., Miami, FL, 33101',
 '30', 'Eagles', 'MatthewMartinez4567@yahoo.com', '555-678-9012', true, false, false, 'Pending', 'Pending', 'https://res.cloudinary.com/dfg9ft030/image/upload/v1686063818/Volunteers/Martinez_Matthew_emufwn.png');
INSERT INTO applications (first_name, last_name, date_of_birth, home_address, availability, school_mascot, email, phone_number, opt_in_text, experience, transportation, bkgrnd_check_approved, admin_approval, photo) VALUES ('Ava', 'Wilson', '1999-01-10', '456 Elm Rd., Dallas, TX, 75201',
 '35', 'Tigers', 'AvaWilson8901@hotmail.com', '555-901-2345', false, true, true, 'Approved', 'Pending', 'https://res.cloudinary.com/dfg9ft030/image/upload/v1686063814/Volunteers/Wilson_Ava_ujzuax.jpg');

INSERT INTO adopter(animal_id, adopter_first_name, adopter_last_name, email, phone_number) VALUES ((SELECT animal_id FROM animals WHERE animal_name = 'Lola'), 'Bob', 'Bob', 'Bob', 'Bob');

COMMIT TRANSACTION;
