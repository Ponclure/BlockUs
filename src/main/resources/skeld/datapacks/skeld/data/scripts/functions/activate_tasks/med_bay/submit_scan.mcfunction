scoreboard objectives add submit_scan dummy
execute at @e[tag=med_bay,tag=submit_scan] as @a[distance=..5] at @s run playsound minecraft:block.beacon.activate master @s ~ ~ ~ 9999

## Crewmate
execute if entity @s[tag=crewmate] run scoreboard players set submit_scan submit_scan 200

## Impostor (null)
#execute if entity @s[tag=impostor] run function scripts:faked