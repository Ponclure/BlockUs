scoreboard objectives add vote_id trigger
scoreboard players enable @a vote_id
scoreboard players set @a vote_id -1
scoreboard players set @a[team=ghost] vote_id 11

tellraw @a[team=ghost] {"text":""}
tellraw @a[team=playing] {"text":"\n Who is The Impostor?","bold":"true","color":"red"}
execute if entity @e[scores={player_id=0},team=playing] run tellraw @a[team=playing] ["",{"text":"   "},{"selector":"@a[scores={player_id=0}]","color":"white"},{"text":" [VOTE]","bold":true,"color":"green","clickEvent":{"action":"run_command","value":"/trigger vote_id set 0"},"hoverEvent":{"action":"show_text","contents":{"text":"Click to vote"}}}]
execute if entity @e[scores={player_id=1},team=playing] run tellraw @a[team=playing] ["",{"text":"   "},{"selector":"@a[scores={player_id=1}]","color":"white"},{"text":" [VOTE]","bold":true,"color":"green","clickEvent":{"action":"run_command","value":"/trigger vote_id set 1"},"hoverEvent":{"action":"show_text","contents":{"text":"Click to vote"}}}]
execute if entity @e[scores={player_id=2},team=playing] run tellraw @a[team=playing] ["",{"text":"   "},{"selector":"@a[scores={player_id=2}]","color":"white"},{"text":" [VOTE]","bold":true,"color":"green","clickEvent":{"action":"run_command","value":"/trigger vote_id set 2"},"hoverEvent":{"action":"show_text","contents":{"text":"Click to vote"}}}]
execute if entity @e[scores={player_id=3},team=playing] run tellraw @a[team=playing] ["",{"text":"   "},{"selector":"@a[scores={player_id=3}]","color":"white"},{"text":" [VOTE]","bold":true,"color":"green","clickEvent":{"action":"run_command","value":"/trigger vote_id set 3"},"hoverEvent":{"action":"show_text","contents":{"text":"Click to vote"}}}]
execute if entity @e[scores={player_id=4},team=playing] run tellraw @a[team=playing] ["",{"text":"   "},{"selector":"@a[scores={player_id=4}]","color":"white"},{"text":" [VOTE]","bold":true,"color":"green","clickEvent":{"action":"run_command","value":"/trigger vote_id set 4"},"hoverEvent":{"action":"show_text","contents":{"text":"Click to vote"}}}]
execute if entity @e[scores={player_id=5},team=playing] run tellraw @a[team=playing] ["",{"text":"   "},{"selector":"@a[scores={player_id=5}]","color":"white"},{"text":" [VOTE]","bold":true,"color":"green","clickEvent":{"action":"run_command","value":"/trigger vote_id set 5"},"hoverEvent":{"action":"show_text","contents":{"text":"Click to vote"}}}]
execute if entity @e[scores={player_id=6},team=playing] run tellraw @a[team=playing] ["",{"text":"   "},{"selector":"@a[scores={player_id=6}]","color":"white"},{"text":" [VOTE]","bold":true,"color":"green","clickEvent":{"action":"run_command","value":"/trigger vote_id set 6"},"hoverEvent":{"action":"show_text","contents":{"text":"Click to vote"}}}]
execute if entity @e[scores={player_id=7},team=playing] run tellraw @a[team=playing] ["",{"text":"   "},{"selector":"@a[scores={player_id=7}]","color":"white"},{"text":" [VOTE]","bold":true,"color":"green","clickEvent":{"action":"run_command","value":"/trigger vote_id set 7"},"hoverEvent":{"action":"show_text","contents":{"text":"Click to vote"}}}]
execute if entity @e[scores={player_id=8},team=playing] run tellraw @a[team=playing] ["",{"text":"   "},{"selector":"@a[scores={player_id=8}]","color":"white"},{"text":" [VOTE]","bold":true,"color":"green","clickEvent":{"action":"run_command","value":"/trigger vote_id set 8"},"hoverEvent":{"action":"show_text","contents":{"text":"Click to vote"}}}]
execute if entity @e[scores={player_id=9},team=playing] run tellraw @a[team=playing] ["",{"text":"   "},{"selector":"@a[scores={player_id=9}]","color":"white"},{"text":" [VOTE]","bold":true,"color":"green","clickEvent":{"action":"run_command","value":"/trigger vote_id set 9"},"hoverEvent":{"action":"show_text","contents":{"text":"Click to vote"}}}]
tellraw @a[team=playing] ["",{"text":"                 "},{"text":" [SKIP]","bold":true,"color":"yellow","clickEvent":{"action":"run_command","value":"/trigger vote_id set 10"},"hoverEvent":{"action":"show_text","contents":{"text":"Click to skip your vote"}}}]

tellraw @a[team=playing] {"text":""}

## Votes
scoreboard objectives add votes dummy
scoreboard players reset @e votes

## Vote bossbar
bossbar add vote_timer {"text":"Voting Time","color":"white"}
bossbar set minecraft:vote_timer style progress
bossbar set minecraft:vote_timer color white
scoreboard players operation timer vote_timer = VotingTimeSec settings
scoreboard players operation timer vote_timer *= ticks_per_sec var
execute store result bossbar minecraft:vote_timer max run scoreboard players get timer vote_timer
bossbar set minecraft:vote_timer players @a