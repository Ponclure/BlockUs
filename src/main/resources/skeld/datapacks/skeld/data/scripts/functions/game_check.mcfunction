## Impostor wins
execute if score crewmates_alive game_track <= impostors_alive game_track run function scripts:impostor_win
execute if score o2 sabotage matches 0 run function scripts:impostor_win
execute if score reactor sabotage matches 0 run function scripts:impostor_win

## Crewmate wins
execute if score impostors_alive game_track matches 0 run function scripts:crewmate_win