package com.esprit.edusched.config;

import com.esprit.edusched.filters.JwtRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfiguration {

    private final JwtRequestFilter jwt;
    @Autowired
    public WebSecurityConfiguration(JwtRequestFilter jwt) {
        this.jwt = jwt;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {

        return security.cors()
                .and().csrf().disable()
                .authorizeHttpRequests()

                .requestMatchers("/signup","/login/*","/login","login/set-password","/createVote/**").permitAll()
                .and()
                . authorizeHttpRequests()
                .requestMatchers("/api/**","/signup/register/verify","/addReservationT","/updateReservationT/{idResT}"
                        ,"/deleteReservationT/{idResT}","/findAllReservationT","/findReservationTById/{idResT}",
                        "/reservations/available","/reservationTs/{idUser}"
                        ,"/reservationTs/terrain/{idTerrain}", "/addTerrain","/updateTerrain/{idTerrain}"
                        ,"/deleteTerrain/{idTerrain}","/findAllTerrains",
                        "/findTerrainById/{idTerrain}","/reservationT/between/{idResT}","/terrains/reserve/{idUser}/{idResT}"
                        ,"/findUserById/{idUser}","/addRating/{idUser}","/findAllRatings","/findRatingById/{id}","/rating/count"
                        ,"/rating/above","/rating/below","/findAll","/addReservation/{idUser}","addCompetition","getAllCompetition"
                        ,"getCompetitionId/**","addTeam","addVote","deleteTeam/**","deleteVote/","getAllTeams","getAllVotes"
                        ,"getTeamById/**","getVoteById/**","updateTeam","updateVote","affecter-equipe/**","addCompetition","getAllCompetition","getCompetitionId/**","addTeam","addVote","createVote/**","deleteTeam/**","deleteVote/","getAllTeams","getAllVotes","getTeamById/**","getVoteById/**","updateTeam","updateVote","affecter-equipe/**","addWithAvailabilityCheck")
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(jwt, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder (){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    }
