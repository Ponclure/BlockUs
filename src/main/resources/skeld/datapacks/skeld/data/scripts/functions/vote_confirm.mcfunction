execute as @a[scores={vote_id=0}] run scoreboard players add @a[scores={player_id=0}] votes 1
execute as @a[scores={vote_id=1}] run scoreboard players add @a[scores={player_id=1}] votes 1
execute as @a[scores={vote_id=2}] run scoreboard players add @a[scores={player_id=2}] votes 1
execute as @a[scores={vote_id=3}] run scoreboard players add @a[scores={player_id=3}] votes 1
execute as @a[scores={vote_id=4}] run scoreboard players add @a[scores={player_id=4}] votes 1
execute as @a[scores={vote_id=5}] run scoreboard players add @a[scores={player_id=5}] votes 1
execute as @a[scores={vote_id=6}] run scoreboard players add @a[scores={player_id=6}] votes 1
execute as @a[scores={vote_id=7}] run scoreboard players add @a[scores={player_id=7}] votes 1
execute as @a[scores={vote_id=8}] run scoreboard players add @a[scores={player_id=8}] votes 1
execute as @a[scores={vote_id=9}] run scoreboard players add @a[scores={player_id=9}] votes 1
execute as @a[scores={vote_id=10}] run scoreboard players add @e[tag=SKIP] votes 1

execute as @a[scores={vote_id=0..10}] at @s run playsound minecraft:vote master @s
execute as @a[scores={vote_id=0..10}] at @s run tellraw @s {"text":"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"}

execute as @a[scores={vote_id=0..}] run scoreboard players set @s vote_id 11