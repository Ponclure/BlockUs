scoreboard players set timer vote_timer -1
bossbar set minecraft:vote_timer players
scoreboard objectives add vote_var dummy
scoreboard players set $max vote_var 0
scoreboard players operation $max vote_var > @e votes
scoreboard players set number vote_var 0

## UI
tellraw @a {"text":"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"}
tellraw @a {"text":"\n Voting Results","bold":"true","color":"red"}
execute if entity @e[scores={player_id=0},team=playing] run tellraw @a ["",{"text":"   "},{"selector":"@a[scores={player_id=0}]","color":"white"},{"text":" "},{"score":{"name":"@a[scores={player_id=0}]","objective":"votes"},"color":"green"}]
execute if entity @e[scores={player_id=1},team=playing] run tellraw @a ["",{"text":"   "},{"selector":"@a[scores={player_id=1}]","color":"white"},{"text":" "},{"score":{"name":"@a[scores={player_id=1}]","objective":"votes"},"color":"green"}]
execute if entity @e[scores={player_id=2},team=playing] run tellraw @a ["",{"text":"   "},{"selector":"@a[scores={player_id=2}]","color":"white"},{"text":" "},{"score":{"name":"@a[scores={player_id=2}]","objective":"votes"},"color":"green"}]
execute if entity @e[scores={player_id=3},team=playing] run tellraw @a ["",{"text":"   "},{"selector":"@a[scores={player_id=3}]","color":"white"},{"text":" "},{"score":{"name":"@a[scores={player_id=3}]","objective":"votes"},"color":"green"}]
execute if entity @e[scores={player_id=4},team=playing] run tellraw @a ["",{"text":"   "},{"selector":"@a[scores={player_id=4}]","color":"white"},{"text":" "},{"score":{"name":"@a[scores={player_id=4}]","objective":"votes"},"color":"green"}]
execute if entity @e[scores={player_id=5},team=playing] run tellraw @a ["",{"text":"   "},{"selector":"@a[scores={player_id=5}]","color":"white"},{"text":" "},{"score":{"name":"@a[scores={player_id=5}]","objective":"votes"},"color":"green"}]
execute if entity @e[scores={player_id=6},team=playing] run tellraw @a ["",{"text":"   "},{"selector":"@a[scores={player_id=6}]","color":"white"},{"text":" "},{"score":{"name":"@a[scores={player_id=6}]","objective":"votes"},"color":"green"}]
execute if entity @e[scores={player_id=7},team=playing] run tellraw @a ["",{"text":"   "},{"selector":"@a[scores={player_id=7}]","color":"white"},{"text":" "},{"score":{"name":"@a[scores={player_id=7}]","objective":"votes"},"color":"green"}]
execute if entity @e[scores={player_id=8},team=playing] run tellraw @a ["",{"text":"   "},{"selector":"@a[scores={player_id=8}]","color":"white"},{"text":" "},{"score":{"name":"@a[scores={player_id=8}]","objective":"votes"},"color":"green"}]
execute if entity @e[scores={player_id=9},team=playing] run tellraw @a ["",{"text":"   "},{"selector":"@a[scores={player_id=9}]","color":"white"},{"text":" "},{"score":{"name":"@a[scores={player_id=9}]","objective":"votes"},"color":"green"}]
tellraw @a ["",{"text":"   Skipped: "},{"score":{"name":"@e[tag=SKIP]","objective":"votes"},"color":"green"}]
tellraw @a ["",{"text":"   Abstained: "},{"selector":"@a[tag=abstain]","color":"white"}]

tellraw @a {"text":""}

## Check how many
execute as @e if score @s votes = $max vote_var run scoreboard players add number vote_var 1

## If = 1
execute as @e if score @s votes = $max vote_var if score number vote_var matches 1 run tag @s add eject

## If more than 1
execute if score number vote_var matches 2.. run tag @e[name=SKIP] add eject



team modify playing nametagVisibility never
tag @a remove abstain
execute if score inspect_sample inspect_sample matches 0.. run scoreboard players add inspect_sample inspect_sample 70