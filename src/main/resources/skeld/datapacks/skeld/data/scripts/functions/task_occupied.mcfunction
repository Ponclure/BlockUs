tag @e[tag=task,scores={faked=0}] remove occupied

# Cafeteria
execute if entity @a[x=-300,y=201,z=-302,dx=6,dy=3,dz=1] run tag @e[tag=cafeteria,tag=fix_wiring] add occupied
execute if entity @a[x=-290,y=201,z=-302,dx=6,dy=3,dz=1] run tag @e[tag=cafeteria,tag=upload_data] add occupied
execute if entity @a[x=-280,y=201,z=-302,dx=6,dy=3,dz=1] run tag @e[tag=cafeteria,tag=empty_garbage] add occupied

## Upper Engine
execute if entity @a[x=-270,y=201,z=-302,dx=6,dy=3,dz=1] run tag @e[tag=upper_engine,tag=divert_power] add occupied
execute if entity @a[x=-260,y=201,z=-302,dx=6,dy=3,dz=1] run tag @e[tag=upper_engine,tag=align_engine] add occupied
execute if entity @a[x=-250,y=201,z=-302,dx=6,dy=3,dz=1] run tag @e[tag=upper_engine,tag=fuel] add occupied

## Reactor
execute if entity @a[x=-240,y=201,z=-313,dx=6,dy=3,dz=1] run tag @e[tag=reactor,tag=divert_power] add occupied
execute if entity @a[x=-300,y=201,z=-313,dx=6,dy=3,dz=1] run tag @e[tag=reactor,tag=unlock_manifolds] add occupied
execute if entity @a[x=-290,y=201,z=-313,dx=6,dy=3,dz=1] run tag @e[tag=reactor,tag=start_reactor] add occupied

## Lower Engine
execute if entity @a[x=-280,y=201,z=-313,dx=6,dy=3,dz=1] run tag @e[tag=lower_engine,tag=divert_power] add occupied
execute if entity @a[x=-270,y=201,z=-313,dx=6,dy=3,dz=1] run tag @e[tag=lower_engine,tag=align_engine] add occupied
execute if entity @a[x=-260,y=201,z=-313,dx=6,dy=3,dz=1] run tag @e[tag=lower_engine,tag=fuel] add occupied

## Security
execute if entity @a[x=-250,y=201,z=-313,dx=6,dy=3,dz=1] run tag @e[tag=security,tag=fix_wiring] add occupied
execute if entity @a[x=-240,y=201,z=-313,dx=6,dy=3,dz=1] run tag @e[tag=security,tag=divert_power] add occupied

## Med Bay
#execute as @e[tag=inspect_sample,tag=med_bay] at @s if entity @p[distance=..1] run tag @s add occupied
#execute as @e[tag=submit_scan,tag=med_bay] at @s if entity @p[distance=..2.0] run tag @s add occupied

## Storage
execute if entity @a[x=-300,y=201,z=-324,dx=6,dy=3,dz=1] run tag @e[tag=storage,tag=fix_wiring] add occupied
execute if entity @a[x=-290,y=201,z=-324,dx=6,dy=3,dz=1] run tag @e[tag=storage,tag=fuel1] add occupied
execute if entity @a[x=-280,y=201,z=-324,dx=6,dy=3,dz=1] run tag @e[tag=storage,tag=fuel2] add occupied
execute if entity @a[x=-270,y=201,z=-324,dx=6,dy=3,dz=1] run tag @e[tag=storage,tag=empty_garbage] add occupied
execute if entity @a[x=-260,y=201,z=-324,dx=6,dy=3,dz=1] run tag @e[tag=storage,tag=empty_chute] add occupied

## Electrical
execute if entity @a[x=-250,y=201,z=-324,dx=6,dy=3,dz=1] run tag @e[tag=electrical,tag=calibrate] add occupied
execute if entity @a[x=-240,y=201,z=-324,dx=6,dy=3,dz=1] run tag @e[tag=electrical,tag=fix_wiring] add occupied
execute if entity @a[x=-300,y=201,z=-335,dx=6,dy=3,dz=1] run tag @e[tag=electrical,tag=divert_power] add occupied
execute if entity @a[x=-290,y=201,z=-335,dx=6,dy=3,dz=1] run tag @e[tag=electrical,tag=upload_data] add occupied

## Admin
execute if entity @a[x=-280,y=201,z=-335,dx=6,dy=3,dz=1] run tag @e[tag=admin,tag=fix_wiring] add occupied
execute if entity @a[x=-270,y=201,z=-335,dx=6,dy=3,dz=1] run tag @e[tag=admin,tag=upload_data] add occupied
execute if entity @a[x=-260,y=201,z=-335,dx=6,dy=3,dz=1] run tag @e[tag=admin,tag=swipe_card] add occupied

## Communications
execute if entity @a[x=-250,y=201,z=-335,dx=6,dy=3,dz=1] run tag @e[tag=communications,tag=upload_data] add occupied
execute if entity @a[x=-240,y=201,z=-335,dx=6,dy=3,dz=1] run tag @e[tag=communications,tag=divert_power] add occupied

## Shields
execute if entity @a[x=-300,y=201,z=-346,dx=6,dy=3,dz=1] run tag @e[tag=shields,tag=prime_shields] add occupied
execute if entity @a[x=-290,y=201,z=-346,dx=6,dy=3,dz=1] run tag @e[tag=shields,tag=divert_power] add occupied

## Weapons
execute if entity @a[x=-280,y=201,z=-346,dx=6,dy=3,dz=1] run tag @e[tag=weapons,tag=divert_power] add occupied
execute if entity @a[x=-270,y=201,z=-346,dx=6,dy=3,dz=1] run tag @e[tag=weapons,tag=clear_asteroids] add occupied
execute if entity @a[x=-260,y=201,z=-346,dx=6,dy=3,dz=1] run tag @e[tag=weapons,tag=upload_data] add occupied

## O2
execute if entity @a[x=-250,y=201,z=-346,dx=6,dy=3,dz=1] run tag @e[tag=o2,tag=divert_power] add occupied
execute if entity @a[x=-240,y=201,z=-346,dx=6,dy=3,dz=1] run tag @e[tag=o2,tag=empty_chute] add occupied
execute if entity @a[x=-300,y=201,z=-357,dx=6,dy=3,dz=1] run tag @e[tag=o2,tag=clean] add occupied

## Navigation
execute if entity @a[x=-290,y=201,z=-357,dx=6,dy=3,dz=1] run tag @e[tag=navigation,tag=fix_wiring] add occupied
execute if entity @a[x=-280,y=201,z=-357,dx=6,dy=3,dz=1] run tag @e[tag=navigation,tag=divert_power] add occupied
execute if entity @a[x=-270,y=201,z=-357,dx=6,dy=3,dz=1] run tag @e[tag=navigation,tag=upload_data] add occupied
execute if entity @a[x=-260,y=201,z=-357,dx=6,dy=3,dz=1] run tag @e[tag=navigation,tag=chart] add occupied
execute if entity @a[x=-250,y=201,z=-357,dx=6,dy=3,dz=1] run tag @e[tag=navigation,tag=stabilise] add occupied

