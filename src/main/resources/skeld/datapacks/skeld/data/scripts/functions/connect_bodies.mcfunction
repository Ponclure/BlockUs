execute as @e[tag=task] run data merge entity @s {ArmorItems:[{},{},{},{id:"minecraft:air"}]}

## Cafeteria
execute if entity @a[tag=!ghost,tag=crewmate,x=-300,y=201,z=-302,dx=6,dy=3,dz=1] run data merge entity @e[tag=cafeteria,tag=fix_wiring,limit=1] {ArmorItems:[{},{},{},{id:"minecraft:carrot_on_a_stick",Count:1b,tag:{CustomModelData:7}}]}
execute if entity @a[tag=!ghost,tag=crewmate,x=-290,y=201,z=-302,dx=6,dy=3,dz=1] run data merge entity @e[tag=cafeteria,tag=upload_data,limit=1] {ArmorItems:[{},{},{},{id:"minecraft:carrot_on_a_stick",Count:1b,tag:{CustomModelData:7}}]}
execute if entity @a[tag=!ghost,tag=crewmate,x=-280,y=201,z=-302,dx=6,dy=3,dz=1] run data merge entity @e[tag=cafeteria,tag=empty_garbage,limit=1] {ArmorItems:[{},{},{},{id:"minecraft:carrot_on_a_stick",Count:1b,tag:{CustomModelData:7}}]}

## Upper Engine
execute if entity @a[tag=!ghost,tag=crewmate,x=-270,y=201,z=-302,dx=6,dy=3,dz=1] run data merge entity @e[tag=upper_engine,tag=divert_power,limit=1] {ArmorItems:[{},{},{},{id:"minecraft:carrot_on_a_stick",Count:1b,tag:{CustomModelData:7}}]}
execute if entity @a[tag=!ghost,tag=crewmate,x=-260,y=201,z=-302,dx=6,dy=3,dz=1] run data merge entity @e[tag=upper_engine,tag=align_engine,limit=1] {ArmorItems:[{},{},{},{id:"minecraft:carrot_on_a_stick",Count:1b,tag:{CustomModelData:7}}]}
execute if entity @a[tag=!ghost,tag=crewmate,x=-250,y=201,z=-302,dx=6,dy=3,dz=1] run data merge entity @e[tag=upper_engine,tag=fuel,limit=1] {ArmorItems:[{},{},{},{id:"minecraft:carrot_on_a_stick",Count:1b,tag:{CustomModelData:7}}]}

## Reactor
execute if entity @a[tag=!ghost,tag=crewmate,x=-240,y=201,z=-313,dx=6,dy=3,dz=1] run data merge entity @e[tag=reactor,tag=divert_power,limit=1] {ArmorItems:[{},{},{},{id:"minecraft:carrot_on_a_stick",Count:1b,tag:{CustomModelData:7}}]}
execute if entity @a[tag=!ghost,tag=crewmate,x=-300,y=201,z=-313,dx=6,dy=3,dz=1] run data merge entity @e[tag=reactor,tag=unlock_manifolds,limit=1] {ArmorItems:[{},{},{},{id:"minecraft:carrot_on_a_stick",Count:1b,tag:{CustomModelData:7}}]}
execute if entity @a[tag=!ghost,tag=crewmate,x=-290,y=201,z=-313,dx=6,dy=3,dz=1] run data merge entity @e[tag=reactor,tag=start_reactor,limit=1] {ArmorItems:[{},{},{},{id:"minecraft:carrot_on_a_stick",Count:1b,tag:{CustomModelData:7}}]}

## Lower Engine
execute if entity @a[tag=!ghost,tag=crewmate,x=-280,y=201,z=-313,dx=6,dy=3,dz=1] run data merge entity @e[tag=lower_engine,tag=divert_power,limit=1] {ArmorItems:[{},{},{},{id:"minecraft:carrot_on_a_stick",Count:1b,tag:{CustomModelData:7}}]}
execute if entity @a[tag=!ghost,tag=crewmate,x=-270,y=201,z=-313,dx=6,dy=3,dz=1] run data merge entity @e[tag=lower_engine,tag=align_engine,limit=1] {ArmorItems:[{},{},{},{id:"minecraft:carrot_on_a_stick",Count:1b,tag:{CustomModelData:7}}]}
execute if entity @a[tag=!ghost,tag=crewmate,x=-260,y=201,z=-313,dx=6,dy=3,dz=1] run data merge entity @e[tag=lower_engine,tag=fuel,limit=1] {ArmorItems:[{},{},{},{id:"minecraft:carrot_on_a_stick",Count:1b,tag:{CustomModelData:7}}]}

## Security
execute if entity @a[tag=!ghost,tag=crewmate,x=-250,y=201,z=-313,dx=6,dy=3,dz=1] run data merge entity @e[tag=security,tag=fix_wiring,limit=1] {ArmorItems:[{},{},{},{id:"minecraft:carrot_on_a_stick",Count:1b,tag:{CustomModelData:7}}]}
execute if entity @a[tag=!ghost,tag=crewmate,x=-240,y=201,z=-313,dx=6,dy=3,dz=1] run data merge entity @e[tag=security,tag=divert_power,limit=1] {ArmorItems:[{},{},{},{id:"minecraft:carrot_on_a_stick",Count:1b,tag:{CustomModelData:7}}]}

## Med Bay (null)

## Storage
execute if entity @a[tag=!ghost,tag=crewmate,x=-300,y=201,z=-324,dx=6,dy=3,dz=1] run data merge entity @e[tag=storage,tag=fix_wiring,limit=1] {ArmorItems:[{},{},{},{id:"minecraft:carrot_on_a_stick",Count:1b,tag:{CustomModelData:7}}]}
execute if entity @a[tag=!ghost,tag=crewmate,x=-290,y=201,z=-324,dx=6,dy=3,dz=1] run data merge entity @e[tag=storage,tag=fuel1,limit=1] {ArmorItems:[{},{},{},{id:"minecraft:carrot_on_a_stick",Count:1b,tag:{CustomModelData:7}}]}
execute if entity @a[tag=!ghost,tag=crewmate,x=-280,y=201,z=-324,dx=6,dy=3,dz=1] run data merge entity @e[tag=storage,tag=fuel2,limit=1] {ArmorItems:[{},{},{},{id:"minecraft:carrot_on_a_stick",Count:1b,tag:{CustomModelData:7}}]}
execute if entity @a[tag=!ghost,tag=crewmate,x=-270,y=201,z=-324,dx=6,dy=3,dz=1] run data merge entity @e[tag=storage,tag=empty_garbage,limit=1] {ArmorItems:[{},{},{},{id:"minecraft:carrot_on_a_stick",Count:1b,tag:{CustomModelData:7}}]}
execute if entity @a[tag=!ghost,tag=crewmate,x=-260,y=201,z=-324,dx=6,dy=3,dz=1] run data merge entity @e[tag=storage,tag=empty_chute,limit=1] {ArmorItems:[{},{},{},{id:"minecraft:carrot_on_a_stick",Count:1b,tag:{CustomModelData:7}}]}

## Electrical
execute if entity @a[tag=!ghost,tag=crewmate,x=-250,y=201,z=-324,dx=6,dy=3,dz=1] run data merge entity @e[tag=electrical,tag=calibrate,limit=1] {ArmorItems:[{},{},{},{id:"minecraft:carrot_on_a_stick",Count:1b,tag:{CustomModelData:7}}]}
execute if entity @a[tag=!ghost,tag=crewmate,x=-240,y=201,z=-324,dx=6,dy=3,dz=1] run data merge entity @e[tag=electrical,tag=fix_wiring,limit=1] {ArmorItems:[{},{},{},{id:"minecraft:carrot_on_a_stick",Count:1b,tag:{CustomModelData:7}}]}
execute if entity @a[tag=!ghost,tag=crewmate,x=-300,y=201,z=-335,dx=6,dy=3,dz=1] run data merge entity @e[tag=electrical,tag=divert_power,limit=1] {ArmorItems:[{},{},{},{id:"minecraft:carrot_on_a_stick",Count:1b,tag:{CustomModelData:7}}]}
execute if entity @a[tag=!ghost,tag=crewmate,x=-290,y=201,z=-335,dx=6,dy=3,dz=1] run data merge entity @e[tag=electrical,tag=upload_data,limit=1] {ArmorItems:[{},{},{},{id:"minecraft:carrot_on_a_stick",Count:1b,tag:{CustomModelData:7}}]}

## Admin
execute if entity @a[tag=!ghost,tag=crewmate,x=-280,y=201,z=-335,dx=6,dy=3,dz=1] run data merge entity @e[tag=admin,tag=fix_wiring,limit=1] {ArmorItems:[{},{},{},{id:"minecraft:carrot_on_a_stick",Count:1b,tag:{CustomModelData:7}}]}
execute if entity @a[tag=!ghost,tag=crewmate,x=-270,y=201,z=-335,dx=6,dy=3,dz=1] run data merge entity @e[tag=admin,tag=upload_data,limit=1] {ArmorItems:[{},{},{},{id:"minecraft:carrot_on_a_stick",Count:1b,tag:{CustomModelData:7}}]}
execute if entity @a[tag=!ghost,tag=crewmate,x=-260,y=201,z=-335,dx=6,dy=3,dz=1] run data merge entity @e[tag=admin,tag=swipe_card,limit=1] {ArmorItems:[{},{},{},{id:"minecraft:carrot_on_a_stick",Count:1b,tag:{CustomModelData:7}}]}

## Communications
execute if entity @a[tag=!ghost,tag=crewmate,x=-250,y=201,z=-335,dx=6,dy=3,dz=1] run data merge entity @e[tag=communications,tag=upload_data,limit=1] {ArmorItems:[{},{},{},{id:"minecraft:carrot_on_a_stick",Count:1b,tag:{CustomModelData:7}}]}
execute if entity @a[tag=!ghost,tag=crewmate,x=-240,y=201,z=-335,dx=6,dy=3,dz=1] run data merge entity @e[tag=communications,tag=divert_power,limit=1] {ArmorItems:[{},{},{},{id:"minecraft:carrot_on_a_stick",Count:1b,tag:{CustomModelData:7}}]}

## Shields
execute if entity @a[tag=!ghost,tag=crewmate,x=-300,y=201,z=-346,dx=6,dy=3,dz=1] run data merge entity @e[tag=shields,tag=prime_shields,limit=1] {ArmorItems:[{},{},{},{id:"minecraft:carrot_on_a_stick",Count:1b,tag:{CustomModelData:7}}]}
execute if entity @a[tag=!ghost,tag=crewmate,x=-290,y=201,z=-346,dx=6,dy=3,dz=1] run data merge entity @e[tag=shields,tag=divert_power,limit=1] {ArmorItems:[{},{},{},{id:"minecraft:carrot_on_a_stick",Count:1b,tag:{CustomModelData:7}}]}

## Weapons
execute if entity @a[tag=!ghost,tag=crewmate,x=-280,y=201,z=-346,dx=6,dy=3,dz=1] run data merge entity @e[tag=weapons,tag=divert_power,limit=1] {ArmorItems:[{},{},{},{id:"minecraft:carrot_on_a_stick",Count:1b,tag:{CustomModelData:7}}]}
execute if entity @a[tag=!ghost,tag=crewmate,x=-270,y=201,z=-346,dx=6,dy=3,dz=1] run data merge entity @e[tag=weapons,tag=clear_asteroids,limit=1] {ArmorItems:[{},{},{},{id:"minecraft:carrot_on_a_stick",Count:1b,tag:{CustomModelData:7}}]}
execute if entity @a[tag=!ghost,tag=crewmate,x=-260,y=201,z=-346,dx=6,dy=3,dz=1] run data merge entity @e[tag=weapons,tag=upload_data,limit=1] {ArmorItems:[{},{},{},{id:"minecraft:carrot_on_a_stick",Count:1b,tag:{CustomModelData:7}}]}

## O2
execute if entity @a[tag=!ghost,tag=crewmate,x=-250,y=201,z=-346,dx=6,dy=3,dz=1] run data merge entity @e[tag=o2,tag=divert_power,limit=1] {ArmorItems:[{},{},{},{id:"minecraft:carrot_on_a_stick",Count:1b,tag:{CustomModelData:7}}]}
execute if entity @a[tag=!ghost,tag=crewmate,x=-240,y=201,z=-346,dx=6,dy=3,dz=1] run data merge entity @e[tag=o2,tag=empty_chute,limit=1] {ArmorItems:[{},{},{},{id:"minecraft:carrot_on_a_stick",Count:1b,tag:{CustomModelData:7}}]}
execute if entity @a[tag=!ghost,tag=crewmate,x=-300,y=201,z=-357,dx=6,dy=3,dz=1] run data merge entity @e[tag=o2,tag=clean,limit=1] {ArmorItems:[{},{},{},{id:"minecraft:carrot_on_a_stick",Count:1b,tag:{CustomModelData:7}}]}

## Navigation
execute if entity @a[tag=!ghost,tag=crewmate,x=-290,y=201,z=-357,dx=6,dy=3,dz=1] run data merge entity @e[tag=navigation,tag=fix_wiring,limit=1] {ArmorItems:[{},{},{},{id:"minecraft:carrot_on_a_stick",Count:1b,tag:{CustomModelData:7}}]}
execute if entity @a[tag=!ghost,tag=crewmate,x=-280,y=201,z=-357,dx=6,dy=3,dz=1] run data merge entity @e[tag=navigation,tag=divert_power,limit=1] {ArmorItems:[{},{},{},{id:"minecraft:carrot_on_a_stick",Count:1b,tag:{CustomModelData:7}}]}
execute if entity @a[tag=!ghost,tag=crewmate,x=-270,y=201,z=-357,dx=6,dy=3,dz=1] run data merge entity @e[tag=navigation,tag=upload_data,limit=1] {ArmorItems:[{},{},{},{id:"minecraft:carrot_on_a_stick",Count:1b,tag:{CustomModelData:7}}]}
execute if entity @a[tag=!ghost,tag=crewmate,x=-260,y=201,z=-357,dx=6,dy=3,dz=1] run data merge entity @e[tag=navigation,tag=chart,limit=1] {ArmorItems:[{},{},{},{id:"minecraft:carrot_on_a_stick",Count:1b,tag:{CustomModelData:7}}]}
execute if entity @a[tag=!ghost,tag=crewmate,x=-250,y=201,z=-357,dx=6,dy=3,dz=1] run data merge entity @e[tag=navigation,tag=stabilise,limit=1] {ArmorItems:[{},{},{},{id:"minecraft:carrot_on_a_stick",Count:1b,tag:{CustomModelData:7}}]}

execute as @e[tag=task,scores={faked=1..}] run data merge entity @s {ArmorItems:[{},{},{},{id:"minecraft:carrot_on_a_stick",Count:1b,tag:{CustomModelData:8}}]}

execute as @e[tag=camera_marker] run data merge entity @s {ArmorItems:[{},{},{},{id:"minecraft:air"}]}
execute if entity @a[tag=!ghost,tag=crewmate,tag=surveil] as @e[tag=camera_marker] run data merge entity @s {ArmorItems:[{},{},{},{id:"minecraft:carrot_on_a_stick",Count:1b,tag:{CustomModelData:7}}]}
execute if entity @a[tag=!ghost,tag=impostor,tag=surveil] as @e[tag=camera_marker] run data merge entity @s {ArmorItems:[{},{},{},{id:"minecraft:carrot_on_a_stick",Count:1b,tag:{CustomModelData:8}}]}
