scoreboard objectives add game_check dummy
scoreboard players operation impostors_var game_check = Impostors settings
scoreboard players operation impostors_var game_check += Impostors settings
scoreboard players operation impostors_var game_check += Impostors settings
scoreboard players add impostors_var game_check 1
scoreboard players operation min_to_play game_check = impostors_var game_check

execute if score players game_track < min_to_play game_check run playsound minecraft:generic master @a ~ ~ ~ 9999
execute if score players game_track < min_to_play game_check run title @a actionbar {"text":"Not enough players to start the game"}

execute if score players game_track matches 11.. run playsound minecraft:generic master @a ~ ~ ~ 9999
execute if score players game_track matches 11.. run title @a actionbar {"text":"Too many players (max. 10)"}

execute if score players game_track matches ..10 if score players game_track >= min_to_play game_check run function scripts:assign

