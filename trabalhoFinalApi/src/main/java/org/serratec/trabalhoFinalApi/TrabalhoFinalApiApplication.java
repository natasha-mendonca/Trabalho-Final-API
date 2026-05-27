package org.serratec.trabalhoFinalApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableJpaAuditing
@EnableScheduling
public class TrabalhoFinalApiApplication {

	public static void main(String[] args) {

		SpringApplication.run(TrabalhoFinalApiApplication.class, args);

		System.out.println("""
				
				                                                    @  =@                                           \s
				                                                  @@@@ #@@                                          \s
				                                                 @@@@@@%@@                                          \s
				                                                @@@@:@@@+@#%@#                                      \s
				                                                      @@%+@@@@@                                     \s
				                                                       @-@@  @@*                                    \s
				                                                  @@@@@ .@@@ @@@@                                   \s
				                                                 @@    =  @*  @  @                                  \s
				                                  @@       @@   @@*-..  @@@%.    .%                                 \s
				                                  @@@     @@@ @@=%@@@@@@@@.@@@@%%@                                \s
				                                  @@@    @@@*  @@. .@@@@    :%@   *:                                \s
				                                  @#@@   @#@   @@@@*     .:     @@@@                                \s
				                                  @@@   @@   @#*@@@@@@@@@@@@@@@. @                                \s
				                                  @**@@ @@=@   @@.......:@@@    :@@@                                \s
				                                  @@+@@ @%=@   @@@@*+=::.....++%@# @                                \s
				                                   @#@=%:@@   :@ @@@%%%+=+@@   @                                \s
				                                   @@@@@@@@#    @  @@@%##*#@@    @                                \s
				                                @@       :@+    @@  @*%@%%%@@@    @@                                \s
				                                @%  =          @@  @@%##*@@     @@:                               \s
				                                @*#@@@@@@@@@   .@@  @@#%@@@@      @@#                               \s
				                              @@@%@@@=@@@@     @@  #@##%@@       @                                \s
				                              @@@@@@@*@@@@         :@@%#%@@                                         \s
				                              @@@@@%*%%@@@        +:@@@%@@=%                                        \s
				                                @@%@@@@@@       :@@@%%@+..%                                       \s
				                                 @@%%@@@      @@@@+%#%@   ::                                      \s
				                                  @@@*#%@@    .: @.+=%#@@:@=@:@                                     \s
				                                  :@@%*@@@   *..@=%#=@  .=*. @                                    \s
				                                  @ @@@=+@@@@@@@@@@%**@@ =  @@ *                                    \s
				                                     =-:::++==-.  .            .                                    \s
				
		""");

	}

}