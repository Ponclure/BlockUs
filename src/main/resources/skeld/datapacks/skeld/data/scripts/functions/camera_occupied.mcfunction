tag @e[tag=camera_marker] remove occupied

# Cafeteria
execute as @e[tag=camera] at @s if entity @p[distance=..0.1] run tag @e[tag=camera_marker] add occupied


