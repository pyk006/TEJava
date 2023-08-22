<template>
  <div class="about-our-team">
    <h1>About Our Team</h1>
    <div class="about-us">
      <div class="team-member">
        <img
          src="@/assets/LaurenHeadshot.jpg"
          alt="headshot"
          class="headshot"
        />
        <div class="team-member-info">
          <div class="team-member-title">
            <h2>Lauren</h2>
            <a href="https://github.com/laurenmccuen" target="_blank"
              >View my Github</a
            >
            <br />
            <a href="https://www.linkedin.com/in/laurenmccuen/" target="_blank"
              >Connect with me on LinkedIn</a
            >
          </div>
          <p>
            Hello ya'll, I'm Lauren! As a seasoned technical career
            professional, I’ve gained a deep understanding of the skills and
            qualities that make a great software engineer and through Tech
            Elevator, I've gained a fresh perspective on software development.
            <br /><br />
            In addition to my technical expertise, I am passionate about
            elevating women in technology. That's why I'm proud to be involved
            with GetWitIt, an organization that empowers women in tech through
            education, mentorship, and community building. I am committed to
            continuing this work to make the tech industry more diverse and
            inclusive for everyone and would love to find a company who shares
            this mission.
            <br /><br />
            When I'm not busy coding, you can find me on my farm, taking care of
            my five horses, six cats, and dog. Let's connect and explore how we
            can work together to build innovative solutions while also having
            some fun along the way!
          </p>
        </div>
      </div>
      <div class="team-member">
        <img
          src="@/assets/PhillipHeadshot.jpg"
          alt="headshot"
          class="headshot"
        />
        <div class="team-member-info">
          <div class="team-member-title">
            <h2>Phillip</h2>
            <a href="http://github.com/pyk006" target="_blank"
              >View my Github</a
            >
            <br />
            <a href="https://www.linkedin.com/in/phillipy-kim/" target="_blank"
              >Connect with me on LinkedIn</a
            >
          </div>
          <p>
            Hey there! I'm Phillip, and I've always been captivated by the
            thrill of problem-solving and the excitement of learning new skills.
            During my university days, I focused on Human Computer Interaction,
            driven by a desire to uncover the best solutions for user-centered
            design.
            <br /><br />
            However, along the way, something unexpected happened – I stumbled
            upon the world of software development. As I dived into the realms
            of HTML, CSS, and JavaScript, a passion ignited within me. I can
            vividly recall the exhilarating moment when I deployed my very first
            portfolio website, crafted entirely from scratch. Sure, it may not
            have been the most visually stunning design, but that feeling of
            accomplishment was unbeatable.
          </p>
        </div>
      </div>

      <div class="team-member">
        <img src="@/assets/CarlyHeadshot.jpg" alt="headshot" class="headshot" />
        <div class="team-member-info">
          <div class="team-member-title">
            <h2>Carly</h2>
            <a
              href="https://www.linkedin.com/in/carly-stockdale/"
              target="_blank"
              >Connect with me on LinkedIn</a
            >
          </div>
          <p>
            Hi! My name is Carly. I thrive on the thrill of problem solving,
            constantly seeking new challenges to conquer. With a background in
            the food service industry, I've honed invaluable
            relationship-building skills while mastering the art of thinking on
            my feet. 
            <br><br>
            Every day presents an opportunity for growth, and I am
            relentless in my pursuit of knowledge. My aspiration is to join a
            dynamic team where I can unleash my creativity, offer innovative
            solutions, and delve deeper into the ever-evolving realm of
            technology. With a passion for expanding my expertise and
            experience, I await the chance to make a lasting impact in the
            technology field.
          </p>
        </div>
      </div>

      <div class="team-member">
        <img
          src="@/assets/Nicole headshot.jpg"
          alt="headshot"
          class="headshot"
        />
        <div class="team-member-info">
          <div class="team-member-title">
            <h2>Nicole</h2>
            <a href="https://nguyenlnicole.github.io/Portfolio/" target="_blank"
              >View my Portfolio</a
            >
            <br />
            <a href="https://github.com/nguyenlnicole" target="_blank"
              >View my Github</a
            >
            <br />
            <a
              href="https://www.linkedin.com/in/nicole-nguyen94/"
              target="_blank"
              >Connect with me on LinkedIn</a
            >
          </div>
          <p>
            Hello, I'm Nicole Nguyen, a friendly, easy-going, and social,
            individual. I am a passionate coder with a background in veterinary
            medicine and healthcare. My love for coding started with Xanga,
            where I discovered the joy of customizing backgrounds using HTML and
            CSS. This led me to explore HTML and CSS further on platforms like
            MySpace.
            <br /><br />
            Though I initially didn't consider coding as a career, I developed
            strong skills in relationship building, problem-solving, and
            cross-team collaboration within healthcare. Recently, I completed a
            14-week full stack software development bootcamp at Tech Elevator,
            and I am currently undergoing technical mentorship with Hanawilo to
            enhance my full stack skills. I'm eager to contribute my coding
            abilities to an innovative technology team and create customized
            products while fostering continuous growth.
          </p>
        </div>
      </div>

      <div class="team-member">
        <img src="@/assets/JamesHeadshot.jpg" alt="headshot" class="headshot" />
        <div class="team-member-info">
          <div class="team-member-title">
            <h2>James</h2>
            <a href="https://github.com/jtruss-dev" target="_blank"
              >View my Github</a
            >
            <br />
            <a
              href="https://www.linkedin.com/in/james-trussell/"
              target="_blank"
              >Connect with me on LinkedIn</a
            >
          </div>
          <p>
            My names is James Trussell. I'm a passionate video editor turned
            full-stack web developer. Transitioning from videography to web
            development, I've honed my technical and creative skills while
            adapting to new challenges. Currently a student at Tech Elevator,
            specializing in Java-based full-stack development, I prioritize
            active learning, collaboration, and innovative problem-solving.
            <br /><br />
            The experience I gained as a video editor and videographer has
            proven to be invaluable in my web development journey. It taught me
            the importance of attention to detail, the ability to deliver
            visually appealing content, and the significance of effective
            communication when working on a team. I'm excited to continue my
            journey as a full-stack web developer, leveraging my technical and
            creative skills to build innovative solutions and contribute to the
            ever-evolving world of technology.
          </p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "about-us",
  data() {
    return {};
  },
};
</script>

<style scoped>
.about-our-team h1 {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  color: rgb(5, 81, 119);
}

.about-us {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
  margin-left: 20px;
  margin-right: 20px;
}

.team-member {
  border: 3px solid rgb(5, 81, 119);
  background-color: rgb(5, 81, 119);
  border-radius: 10px;
  width: 400px;
  height: 500px;
  padding: 10px;
  margin: 10px;
}

.headshot {
  width: 100px;
  height: 100px;
  object-fit: cover;
  object-position: center top;
  border-radius: 50%;
  margin-top: 10px;
  margin-bottom: 5px;
}

.team-member h2 {
  font-size: 18px;
  margin-bottom: 0.5rem;
  color: whitesmoke;
}

.team-member p {
  font-size: 14px;
  color: whitesmoke;
}

.team-member-title a{
  font-size: 14px;
  color: whitesmoke;
}
</style>
