execute unless entity @e[scores={faked=1..}] run tag @e[tag=task,limit=1,sort=nearest] add occupied
execute unless entity @e[scores={faked=1..}] run effect give @s invisibility 6 0 true
execute unless entity @e[scores={faked=1..}] run playsound minecraft:fake master @s
execute unless entity @e[scores={faked=1..}] run title @s title {"text":""}
execute unless entity @e[scores={faked=1..}] run title @s subtitle {"text":"Task faked","italic":"true"}
execute unless entity @e[scores={faked=1..}] run scoreboard players set @e[tag=task,limit=1,sort=nearest] faked 120