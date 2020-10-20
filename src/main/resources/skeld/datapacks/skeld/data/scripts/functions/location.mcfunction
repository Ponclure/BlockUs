execute at @e[limit=1,sort=nearest,tag=door] if entity @e[distance=..0.1,tag=cafeteria] run scoreboard players set @s location 1
execute at @e[limit=1,sort=nearest,tag=door] if entity @e[distance=..0.1,tag=upper_engine] run scoreboard players set @s location 2
execute at @e[limit=1,sort=nearest,tag=door] if entity @e[distance=..0.1,tag=reactor] run scoreboard players set @s location 3
execute at @e[limit=1,sort=nearest,tag=door] if entity @e[distance=..0.1,tag=lower_engine] run scoreboard players set @s location 4
execute at @e[limit=1,sort=nearest,tag=door] if entity @e[distance=..0.1,tag=security] run scoreboard players set @s location 5
execute at @e[limit=1,sort=nearest,tag=door] if entity @e[distance=..0.1,tag=med_bay] run scoreboard players set @s location 6
execute at @e[limit=1,sort=nearest,tag=door] if entity @e[distance=..0.1,tag=electrical] run scoreboard players set @s location 7
execute at @e[limit=1,sort=nearest,tag=door] if entity @e[distance=..0.1,tag=storage] run scoreboard players set @s location 8
execute at @e[limit=1,sort=nearest,tag=door] if entity @e[distance=..0.1,tag=communications] run scoreboard players set @s location 9
execute at @e[limit=1,sort=nearest,tag=door] if entity @e[distance=..0.1,tag=admin] run scoreboard players set @s location 10
execute at @e[limit=1,sort=nearest,tag=door] if entity @e[distance=..0.1,tag=shields] run scoreboard players set @s location 11
execute at @e[limit=1,sort=nearest,tag=door] if entity @e[distance=..0.1,tag=weapons] run scoreboard players set @s location 12
execute at @e[limit=1,sort=nearest,tag=door] if entity @e[distance=..0.1,tag=o2] run scoreboard players set @s location 13
execute at @e[limit=1,sort=nearest,tag=door] if entity @e[distance=..0.1,tag=navigation] run scoreboard players set @s location 14

## Corrections
execute if block ~ 0 ~ white_wool run scoreboard players set @s location 1
execute if block ~ 0 ~ orange_wool run scoreboard players set @s location 2
execute if block ~ 0 ~ magenta_wool run scoreboard players set @s location 3
execute if block ~ 0 ~ light_blue_wool run scoreboard players set @s location 4
execute if block ~ 0 ~ yellow_wool run scoreboard players set @s location 5
execute if block ~ 0 ~ lime_wool run scoreboard players set @s location 6
execute if block ~ 0 ~ pink_wool run scoreboard players set @s location 7
execute if block ~ 0 ~ gray_wool run scoreboard players set @s location 8
execute if block ~ 0 ~ light_gray_wool run scoreboard players set @s location 9
execute if block ~ 0 ~ cyan_wool run scoreboard players set @s location 10
execute if block ~ 0 ~ purple_wool run scoreboard players set @s location 11
execute if block ~ 0 ~ blue_wool run scoreboard players set @s location 12
execute if block ~ 0 ~ brown_wool run scoreboard players set @s location 13
execute if block ~ 0 ~ green_wool run scoreboard players set @s location 14
